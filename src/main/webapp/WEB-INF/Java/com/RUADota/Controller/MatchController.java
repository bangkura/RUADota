package com.RUADota.Controller;

import com.RUADota.DAO.MatchDao;
import com.RUADota.Entity.Error;
import com.RUADota.Exception.MatchDetailsNotFoundException;
import com.bangkura.Dota2ApiWrapper.Model.Match;
import com.bangkura.Dota2ApiWrapper.Model.MatchDetails;
import com.bangkura.Dota2ApiWrapper.Model.MatchHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MatchController{
    @Autowired
    private MatchDao matchDao;

    @RequestMapping("/matches/{match_id}")
    public
    MatchDetails getMatch(@PathVariable("match_id") long matchId) throws MatchDetailsNotFoundException{
        MatchDetails matchDetails =  matchDao.getMatchDetailsByMatchId(matchId);
        if(matchDetails == null)
            throw new MatchDetailsNotFoundException();
        return matchDetails;
    }

}
