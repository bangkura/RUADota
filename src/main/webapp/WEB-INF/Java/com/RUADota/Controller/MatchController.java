package com.RUADota.Controller;

import com.bangkura.Dota2ApiWrapper.Api.GetMatchDetails;
import com.bangkura.Dota2ApiWrapper.Exception.WrongUrlException;
import com.bangkura.Dota2ApiWrapper.Model.MatchDetails;
import com.mongodb.BasicDBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MatchController {
    @Autowired
    private MongoOperations mongo;

    @RequestMapping("/matches/{match_id}")
    public @ResponseBody MatchDetails getMatch(@PathVariable("match_id") long matchId) {
        MatchDetails match = null;
        match = mongo.findOne(Query.query(Criteria.where("match_id").is(matchId)), MatchDetails.class);
        if(match != null)
            return match;
        GetMatchDetails api = new GetMatchDetails();
        api.setMatchId(matchId);
        try {
            match = api.excute();
        } catch (WrongUrlException e) {
            match =  new MatchDetails();
        }
        mongo.save(match);
        return match;
    }
}
