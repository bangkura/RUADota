package com.bangkura.Dota2ApiWrapper.Api;

import com.bangkura.Dota2ApiWrapper.Exception.WrongUrlException;
import com.bangkura.Dota2ApiWrapper.Model.Hero;
import com.bangkura.Dota2ApiWrapper.Util.Defines;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;

import java.util.ArrayList;

public class GetHeroes extends BaseApi{
    private static final String LANGUAGE = "language";
    private static final String ITEMIZEDONLY = "itemizedonly";

    public GetHeroes() {
        baseUrl = Defines.GET_HEROS;
    }

    public GetHeroes setLanguage(String language) {
        parameters.put(LANGUAGE, language);
        return this;
    }

    public GetHeroes setItemizedOnly(String tag) {
        parameters.put(ITEMIZEDONLY, tag);
        return this;
    }

    public ArrayList<Hero> excute(){
        ArrayList<Hero> result = new ArrayList<Hero>();
        try {
            TreeNode resultNode = getResultNode();
            TreeNode itemsNode = resultNode.path("heroes");
            for(int i = 0; i < itemsNode.size(); ++i) {
                TreeNode itemNode = itemsNode.get(i);
                Hero hero = mapper.treeToValue(itemNode, Hero.class);
                result.add(hero);
            }
        } catch(JsonProcessingException | WrongUrlException e) {
            e.printStackTrace();
        }
        return result;
    }
}
