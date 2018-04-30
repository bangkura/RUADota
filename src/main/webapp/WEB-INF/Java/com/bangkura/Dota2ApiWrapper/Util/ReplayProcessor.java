package com.bangkura.Dota2ApiWrapper.Util;

import skadistats.clarity.model.Entity;
import skadistats.clarity.processor.entities.Entities;
import skadistats.clarity.processor.entities.UsesEntities;
import skadistats.clarity.processor.reader.OnTickStart;
import skadistats.clarity.processor.runner.Context;

import java.io.IOException;

@UsesEntities
public class ReplayProcessor {
    @OnTickStart
    public void onTickStart(Context ctx, boolean synthetic) throws IOException {
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
        System.out.println(realTime.intValue()/60 + ":" + realTime.intValue()%60);


    }


}
