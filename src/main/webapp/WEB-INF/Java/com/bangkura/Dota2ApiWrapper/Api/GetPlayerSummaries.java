package com.bangkura.Dota2ApiWrapper.Api;

import com.bangkura.Dota2ApiWrapper.Model.PlayerSummary;
import com.bangkura.Dota2ApiWrapper.Util.Defines;
import com.bangkura.Dota2ApiWrapper.Util.Util;
import com.fasterxml.jackson.core.TreeNode;


public class GetPlayerSummaries extends BaseApi {
    private static final String STEAMIDS = "steamids";

    public GetPlayerSummaries() {
        baseUrl = Defines.GET_PLAYER_SUMMARIES;
    }

    public GetPlayerSummaries setSteamids(long id) {
        parameters.put(STEAMIDS, Util.thirtytwoToSixtyFour(id));
        return this;
    }

    public PlayerSummary excute() {
        PlayerSummary summary = null;
        try {
            TreeNode response = getResponseNode();
            summary = mapper.treeToValue(response.path("players").get(0), PlayerSummary.class);
            //System.out.println(response.path("players").get(0));
        } catch(Exception e) {
            e.printStackTrace();
        }
        return summary;
    }
}
