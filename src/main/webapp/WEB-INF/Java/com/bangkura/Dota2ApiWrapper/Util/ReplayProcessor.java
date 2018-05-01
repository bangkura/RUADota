package com.bangkura.Dota2ApiWrapper.Util;

import com.bangkura.Dota2ApiWrapper.Model.HeroEntity;
import com.bangkura.Dota2ApiWrapper.Model.Replay;
import com.bangkura.Dota2ApiWrapper.Model.Tick;
import skadistats.clarity.model.Entity;
import skadistats.clarity.processor.entities.Entities;
import skadistats.clarity.processor.entities.UsesEntities;
import skadistats.clarity.processor.reader.OnMessage;
import skadistats.clarity.processor.reader.OnTickStart;
import skadistats.clarity.processor.runner.Context;
import skadistats.clarity.processor.runner.SimpleRunner;
import skadistats.clarity.source.InputStreamSource;
import skadistats.clarity.util.Predicate;
import skadistats.clarity.wire.s2.proto.S2UserMessages;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@UsesEntities
public class ReplayProcessor {
    private Replay replay = new Replay();
    private List<Tick> ticks = new ArrayList<>();

    @OnTickStart
    public void onTickStart(Context ctx, boolean synthetic) throws IOException {
        Float realTime = timeConvert(ctx);
        if(realTime != null && realTime.floatValue() > 0) {
            Tick tick = new Tick();
            tick.setTime(realTime.longValue());
            List<HeroEntity> herolist = new ArrayList<>();
            tick.setHeroEntities(herolist);
            Entities entities = ctx.getProcessor(Entities.class);
            Iterator<Entity> heroite = entities.getAllByPredicate(new Predicate<Entity>() {
                @Override
                public boolean apply(Entity entity) {
                    if(entity.getDtClass().getDtName().startsWith("CDOTA_Unit_Hero"))
                        return true;
                    else
                        return false;
                }
            });
            while(heroite.hasNext()) {
                Entity entity = heroite.next();
                HeroEntity heroEntity = new HeroEntity();
                heroEntity.setLevel((int)entity.getProperty("m_iCurrentLevel"));
                heroEntity.setName(entity.getDtClass().getDtName());
                herolist.add(heroEntity);
            }
            ticks.add(tick);
        }
    }

    private Float timeConvert(Context ctx) {
        Entities entities = ctx.getProcessor(Entities.class);
        Float gameTime = null;
        String TIME_PRE_PROP = "m_pGameRules.m_flPreGameStartTime";
        String TIME_CUR_PROP = "m_pGameRules.m_fGameTime";
        Entity grules = entities.getByDtName("CDOTAGamerulesProxy");
        Float startTime = null;
        Float preGameTime = null;
        Float transitionTime = null;
        Float realTime = null;
        String TIME_STA_PROP = "m_pGameRules.m_flGameStartTime";
        String TIME_TRN_PROP = "m_pGameRules.m_flStateTransitionTime";
        Float TIME_EPS = new Float(0.01);
        if (grules != null) {
            gameTime = grules.getProperty(TIME_CUR_PROP);

            // before the match starts, there's no game "time"
            if (gameTime != null) {
                preGameTime = grules.getProperty(TIME_PRE_PROP);

                // before hero picking and strategy time are finished, the
                //  pre-game countdown is still at 0, i.e. nothing has happened
                //  in the match
                if (preGameTime > TIME_EPS) {
                    startTime = grules.getProperty(TIME_STA_PROP);

                    // time after the clock hits 0:00
                    if (startTime > TIME_EPS) {
                        realTime = gameTime - startTime;
                    }

                    // between the pre-game and 0:00 time of the match, the
                    //  transition time reflects when the match is supposed to
                    //  start (i.e. hit 0:00 on the clock), and gives a good
                    //  approximation of when the match will start. Up to that
                    //  point, the start time is set to 0.
                    else {
                        transitionTime = grules.getProperty(TIME_TRN_PROP);
                        realTime = gameTime - transitionTime;
                    }
                }
            }
        }
        return realTime;
    }

    //@OnMessage(S2UserMessages.CUserMessageSayText2.class)
    public void onMessage(Context ctx, S2UserMessages.CUserMessageSayText2 message) {
        System.out.format("%s: %s\n", message.getParam1(), message.getParam2());
    }

    public Replay excute(InputStream is) {
        try {
            SimpleRunner runner = new SimpleRunner(new InputStreamSource(is));
            runner.runWith(this);
        } catch(IOException e) {
            e.printStackTrace();
        }
        replay.setTicks(ticks);
        return replay;
    }

}
