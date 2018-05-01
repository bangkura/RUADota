package com.RUADota.DAO;

import com.bangkura.Dota2ApiWrapper.Model.MatchDetails;
import com.bangkura.Dota2ApiWrapper.Model.MatchHistory;

import java.util.List;

public interface MatchDao {
    public List<MatchDetails> getMatchDetailsByUserId(long id);
    public MatchDetails getMatchDetailsByMatchId(long id);
    public void syncUser(long id);
}
