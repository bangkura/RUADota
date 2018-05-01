package com.RUADota.DAO;

import com.bangkura.Dota2ApiWrapper.Api.GetMatchDetails;
import com.bangkura.Dota2ApiWrapper.Api.GetMatchHistory;
import com.bangkura.Dota2ApiWrapper.Exception.WrongUrlException;
import com.bangkura.Dota2ApiWrapper.Model.Hero;
import com.bangkura.Dota2ApiWrapper.Model.Match;
import com.bangkura.Dota2ApiWrapper.Model.MatchDetails;
import com.bangkura.Dota2ApiWrapper.Model.MatchHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.*;

@Service
public class MatchDaoImp implements MatchDao{
    @Autowired
    private MongoOperations mongo;

    @Autowired
    private HeroDao heroDao;

    @Override
    public List<MatchDetails> getMatchDetailsByUserId(long id) {
        return mongo.find(Query.query(Criteria.where("players.account_id").is(id)), MatchDetails.class);
    }

    @Override
    public MatchDetails getMatchDetailsByMatchId(long id) {
        MatchDetails matchDetails = mongo.findOne(Query.query(Criteria.where("match_id").is(id)), MatchDetails.class);
        if(matchDetails != null)
            return matchDetails;
        else {
            syncMatch(id);
            return mongo.findOne(Query.query(Criteria.where("match_id").is(id)), MatchDetails.class);
        }
    }

    private void syncMatch(long matchId) {
        GetMatchDetails api = new GetMatchDetails();
        api.setMatchId(matchId);
        MatchDetails matchDetails = api.excute();
        if(matchDetails != null && matchDetails.getHuman_players() == 10)
            mongo.save(matchDetails);
    }

    @Override
    public void syncUser(long id) {
        List<Hero> heroes = heroDao.getAllHeroes();
        ExecutorService pool = Executors.newCachedThreadPool();
        for(Hero hero : heroes) {
            pool.submit(new Historysyncer(id, hero.getId()));
        }
        pool.shutdown();
    }

    private class Historysyncer implements Runnable {

        private long userId;
        private int heroId;

        public Historysyncer(long userId, int heroId) {
            this.heroId = heroId;
            this.userId = userId;
        }

        @Override
        public void run() {
            syncUserMatchByHero(userId, heroId);
        }
    }

    private void syncUserMatchByHero(long accountId, int heroId) {
        GetMatchHistory api = new GetMatchHistory();
        api.setAccountId(accountId);
        api.setHeroId(heroId);
        api.setMatchesRequested(100);
        api.setStartAtMatchId(Long.MAX_VALUE);
        ExecutorService pool = Executors.newCachedThreadPool();
        int matchRemaining = 0;
        do {
            MatchHistory history = api.excute();
            if(history != null) {
                for(Match match : history.getMatches()) {
                    pool.submit(new MatchSyncer(match.getMatch_id(), heroId));
                }
            }
            matchRemaining = history.getResults_remaining();
            api.setStartAtMatchId(history.getMatches().get(history.getMatches().size()-1).getMatch_id() - 1);
        } while(matchRemaining != 0);
        pool.shutdown();
    }

    private class MatchSyncer implements Runnable {
        private long matchId;
        private int heroId;

        public MatchSyncer(long matchId, int heroId) {
            this.matchId = matchId;
            this.heroId = heroId;
        }

        @Override
        public void run() {
            syncMatch(matchId);
            //System.out.println("Syncing match: " + matchId + " with hero " + heroId + "finished");
        }
    }
}
