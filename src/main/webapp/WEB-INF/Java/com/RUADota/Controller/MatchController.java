package com.RUADota.Controller;

import com.RUADota.DAO.MatchDao;
import com.bangkura.Dota2ApiWrapper.Model.MatchDetails;
import com.bangkura.Dota2ApiWrapper.Model.MatchHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class MatchController {
    @Autowired
    private MatchDao matchDao;

    @RequestMapping("/matches/{match_id}")
    public @ResponseBody
    MatchDetails getMatch(@PathVariable("match_id") long matchId) {
        return matchDao.getMatchDetailsByMatchId(matchId);
    }

    @RequestMapping("/matches/test/{user_id}")
    public
    void test(@PathVariable("user_id") long userId) {
        matchDao.syncUser(userId);
    }
}
