package com.bangkura.Dota2ApiWrapper;

import com.bangkura.Dota2ApiWrapper.Api.*;
import com.bangkura.Dota2ApiWrapper.Exception.WrongUrlException;
import com.bangkura.Dota2ApiWrapper.Model.*;
import com.bangkura.Dota2ApiWrapper.Util.ReplayProcessor;
import com.bangkura.Dota2ApiWrapper.Util.Util;
import com.bangkura.replayparser.ApiWrapper;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Test {
    public static void main(String... args) {
//        GetReplay api = new GetReplay();
//        try {
//            File file = new File("replay.dem");
//            FileInputStream fs = new FileInputStream(file);
//            ReplayProcessor processor = new ReplayProcessor();
//            Replay replay = processor.excute(fs);
//            for(Tick tick : replay.getTicks()) {
//                System.out.println(tick.getTime());
//            }
//        } catch(IOException  e) {
//            e.printStackTrace();
//        }
        GetHeroes api = new GetHeroes();
        GetMatchHistory history = new GetMatchHistory();
        history.setAccountId(184756479);
        history.setMatchesRequested(100);
        List<Hero> heroes = api.excute();
        for(Hero hero: heroes) {
            history.setHeroId(hero.getId());
            System.out.println(hero.getName());
            MatchHistory matchHistory = history.excute();
            for(Match match: matchHistory.getMatches()) {
                System.out.println(match.getMatch_id());
            }
        }
    }
}