package com.bangkura.Dota2ApiWrapper.Api;

import com.bangkura.Dota2ApiWrapper.Exception.WrongUrlException;
import com.bangkura.Dota2ApiWrapper.Model.Item;
import com.bangkura.Dota2ApiWrapper.Util.Defines;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;

import java.util.ArrayList;

public class GetGameItems extends BaseApi{
    private static final String LANGUAGE = "language";

    public GetGameItems() {
        baseUrl = Defines.GET_GAME_ITEMS;
    }

    public GetGameItems setLanguage(String language) {
        parameters.put(LANGUAGE, language);
        return this;
    }


    public ArrayList<Item> excute() throws WrongUrlException{
        ArrayList<Item> result = new ArrayList<Item>();
        TreeNode resultNode = getResultNode();
        TreeNode itemsNode = resultNode.path("items");
        try {
            for(int i = 0; i < itemsNode.size(); ++i) {
                TreeNode itemNode = itemsNode.get(i);
                Item item = mapper.treeToValue(itemNode, Item.class);
                result.add(item);
            }
        } catch(JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
