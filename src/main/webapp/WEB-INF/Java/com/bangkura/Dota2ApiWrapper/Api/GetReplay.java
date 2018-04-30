package com.bangkura.Dota2ApiWrapper.Api;

import com.bangkura.Dota2ApiWrapper.Exception.WrongUrlException;
import com.bangkura.Dota2ApiWrapper.Model.MatchTick;
import com.bangkura.Dota2ApiWrapper.Util.Defines;
import com.bangkura.Dota2ApiWrapper.Util.Util;
import com.fasterxml.jackson.core.TreeNode;

import java.io.IOException;
import java.util.ArrayList;

public class GetReplay extends BaseApi{
    private static final String MATCH_ID = "match_id";
    private static final String CLUSTER_ID = "cluster_id";
    private static final String REPLAY_SALT = "replay_salt";
    public GetReplay() {
    }

    @Override
    public String getApiUrl() throws NullPointerException{
        if(parameters.get(MATCH_ID) == null)
            throw new NullPointerException("the parameter match id is not defined");
        return "http://replay" + parameters.get(CLUSTER_ID) + ".valve.net/570/" + parameters.get(MATCH_ID) + "_" + parameters.get(REPLAY_SALT) + ".dem.bz2";
    }

    public GetReplay setMatchId(long matchId) throws WrongUrlException{
        parameters.put(MATCH_ID, matchId + "");
        String matchDetail = Util.DoHttpRequest(Defines.GET_REPLAY_SALT + "/?match_id=" + matchId);
        try {
            TreeNode resultNode = mapper.readTree(matchDetail);
            if ((resultNode = resultNode.get(0)) == null)
                throw new WrongUrlException(Defines.GET_REPLAY_SALT + "/?match_id=" + matchId);
            parameters.put(REPLAY_SALT, resultNode.path("replay_salt").toString());
            parameters.put(CLUSTER_ID, resultNode.path("cluster").toString());
        } catch(IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public ArrayList<MatchTick> excute() {

        return new ArrayList<MatchTick>();
    }
}
