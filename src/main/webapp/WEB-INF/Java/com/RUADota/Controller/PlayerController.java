package com.RUADota.Controller;

import com.bangkura.Dota2ApiWrapper.Api.GetPlayerSummaries;
import com.bangkura.Dota2ApiWrapper.Model.MatchDetails;
import com.bangkura.Dota2ApiWrapper.Model.PlayerSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(method = RequestMethod.GET)
public class PlayerController {
    @Autowired
    private MongoOperations mongo;

    @RequestMapping(value = "/players/{id}")
    public @ResponseBody PlayerSummary getPlayer(@PathVariable("id") long id) {
        GetPlayerSummaries api = new GetPlayerSummaries();
        api.setSteamids(id);
        return api.excute();
    }

    @RequestMapping(value="players/{id}/matches")
    public @ResponseBody
    List<MatchDetails> getMatches(@PathVariable("id") long id) {
        return new ArrayList<MatchDetails>();
    }
}
