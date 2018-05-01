package com.RUADota.Util;

import com.bangkura.Dota2ApiWrapper.Api.GetHeroes;
import com.bangkura.Dota2ApiWrapper.Exception.WrongUrlException;
import com.bangkura.Dota2ApiWrapper.Model.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataGetter {
    @Autowired
    private static MongoOperations mongo;

    public static List<Hero> getHeroes() {
        GetHeroes api = new GetHeroes();
        List<Hero> result = null;
        result = api.excute();
        for(Hero hero: result) {
            mongo.save(hero);
        }
        return result;
    }
}
