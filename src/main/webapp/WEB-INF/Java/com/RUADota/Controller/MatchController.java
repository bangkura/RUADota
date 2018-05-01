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

    @RequestMapping("/matches/{match_id}")
    public @ResponseBody MatchDetails getMatch(@PathVariable("match_id") long matchId) {
        MatchDetails match = null;
        return match;
    }
}
