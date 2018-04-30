package com.bangkura.Dota2ApiWrapper.Api;

import com.bangkura.Dota2ApiWrapper.Exception.WrongUrlException;
import com.bangkura.Dota2ApiWrapper.Model.Hero;
import com.bangkura.Dota2ApiWrapper.Util.Defines;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;

import java.util.ArrayList;

public class GetHeros extends BaseApi{
    private static final String LANGUAGE = "language";
    private static final String ITEMIZEDONLY = "itemizedonly";

    public GetHeros() {
        baseUrl = Defines.GET_HEROS;
    }

    public GetHeros setLanguage(String language) {
        parameters.put(LANGUAGE, language);
        return this;
    }

    public GetHeros setItemizedOnly(String tag) {
        parameters.put(ITEMIZEDONLY, tag);
        return this;
    }

    public ArrayList<Hero> excute() throws WrongUrlException {
        ArrayList<Hero> result = new ArrayList<Hero>();
        TreeNode resultNode = getResultNode();
        TreeNode itemsNode = resultNode.path("heroes");
        try {
            for(int i = 0; i < itemsNode.size(); ++i) {
                TreeNode itemNode = itemsNode.get(i);
                Hero hero = mapper.treeToValue(itemNode, Hero.class);
                result.add(hero);
            }
        } catch(JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
