package com.RUADota.DAO;

import com.bangkura.Dota2ApiWrapper.Api.GetHeroes;
import com.bangkura.Dota2ApiWrapper.Model.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroDaoImp implements HeroDao{
    @Autowired
    private MongoOperations mongo;

    @Override
    public List<Hero> getAllHeroes() {
        List<Hero> heroes = null;
        heroes = mongo.findAll(Hero.class);
        if(heroes.size() > 0)
            return heroes;
        else {
            syncHeroes();
            return getAllHeroes();
        }
    }

    private void syncHeroes() {
        GetHeroes api = new GetHeroes();
        List<Hero> heroes = api.excute();
        for(Hero hero: heroes) {
            mongo.save(hero);
        }
    }
}
