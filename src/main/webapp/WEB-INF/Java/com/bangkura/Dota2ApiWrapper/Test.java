package com.bangkura.Dota2ApiWrapper;

import com.bangkura.Dota2ApiWrapper.Api.*;
import com.bangkura.Dota2ApiWrapper.Exception.WrongUrlException;
import com.bangkura.Dota2ApiWrapper.Model.MatchHistory;
import com.bangkura.Dota2ApiWrapper.Util.Util;
import com.bangkura.replayparser.ApiWrapper;

public class Test {
    public static void main(String... args) {
        GetReplay test = new GetReplay();
        try {
            test.setMatchId(3819292612L);
            System.out.println(test.getApiUrl());
        } catch(WrongUrlException e) {
            e.printStackTrace();
        }

        String api = ApiWrapper.getReplayUrl("3857767615");
        System.out.println(api);
    }
}