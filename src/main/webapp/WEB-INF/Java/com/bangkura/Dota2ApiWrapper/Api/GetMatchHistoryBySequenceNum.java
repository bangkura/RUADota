package com.bangkura.Dota2ApiWrapper.Api;

import com.bangkura.Dota2ApiWrapper.Util.Defines;

public class GetMatchHistoryBySequenceNum extends BaseApi {
    private static final String START_AT_MATCH_SEQ_NUM = "start_at_match_seq_num";
    private static final String MATCHES_REQUESTED = "matches_requested";

    public GetMatchHistoryBySequenceNum() {
        baseUrl = Defines.GET_MATCH_HISTORY_BY_SEQUENCE_NUMBER;
    }

    public GetMatchHistoryBySequenceNum setStartAtMatchSeqNum(long num) {
        parameters.put(START_AT_MATCH_SEQ_NUM, num + "");
        return this;
    }

    public GetMatchHistoryBySequenceNum setMatchesRequested(int value) {
        parameters.put(MATCHES_REQUESTED, value + "");
        return this;
    }
}
