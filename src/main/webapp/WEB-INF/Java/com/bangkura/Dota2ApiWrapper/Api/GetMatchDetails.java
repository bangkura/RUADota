package com.bangkura.Dota2ApiWrapper.Api;

import com.bangkura.Dota2ApiWrapper.Exception.WrongUrlException;
import com.bangkura.Dota2ApiWrapper.Model.MatchDetails;
import com.bangkura.Dota2ApiWrapper.Util.Defines;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;

public class GetMatchDetails extends BaseApi{
    private static final String MATCH_ID = "match_id";

    public GetMatchDetails() {
        baseUrl = Defines.GET_MATCH_DETAILS;
    }

    public GetMatchDetails setMatchId(long matchId) {
        parameters.put(MATCH_ID, matchId + "");
        return this;
    }

    public MatchDetails excute(){
        MatchDetails matchDetail = null;
        TreeNode result;
        try {
            result = getResultNode();
        } catch(WrongUrlException e) {
            return null;
        }
        try {
            matchDetail = mapper.treeToValue(result, MatchDetails.class);
        } catch(JsonProcessingException e) {
            e.printStackTrace();
        }
        return matchDetail;
    }
}
