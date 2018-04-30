package com.bangkura.Dota2ApiWrapper.Api;

import com.bangkura.Dota2ApiWrapper.Exception.WrongUrlException;
import com.bangkura.Dota2ApiWrapper.Model.MatchHistory;
import com.bangkura.Dota2ApiWrapper.Parameters.GameMode;
import com.bangkura.Dota2ApiWrapper.Parameters.Skill;
import com.bangkura.Dota2ApiWrapper.Util.Defines;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;

public class GetMatchHistory extends BaseApi {
    private static final String HERO_ID = "hero_id";
    private static final String GAME_MODE = "game_mode";
    private static final String SKILL = "game_mode";
    private static final String MIN_PLAYERS = "min_players";
    private static final String ACCOUNT_ID = "account_id";
    private static final String LEAGUE_ID = "league_id";
    private static final String START_AT_MATCH_ID = "start_at_match_id";
    private static final String MATCHES_REQUESTED = "matches_requested";
    private static final String TOURNAMENT_GAMES_ONLY = "tournament_games_only";

    public GetMatchHistory() {
        baseUrl = Defines.GET_MATCH_HISTORY;
    }

    public GetMatchHistory setHeroId(int heroId) {
        parameters.put(HERO_ID, heroId + "");
        return this;
    }

    public GetMatchHistory setGameMode(GameMode gameMode) {
        parameters.put(GAME_MODE, gameMode.ordinal() + "");
        return this;
    }

    public GetMatchHistory setSkill(Skill skill) {
        parameters.put(SKILL, skill.ordinal() + "");
        return this;
    }

    public GetMatchHistory setMinPlayers(int minPlayers) {
        parameters.put(MIN_PLAYERS, minPlayers + "");
        return this;
    }

    public GetMatchHistory setAccountId(long accountId) {
        parameters.put(ACCOUNT_ID, accountId + "");
        return this;
    }

    public GetMatchHistory setLeagueId(long leagueId) {
        parameters.put(LEAGUE_ID, leagueId + "");
        return this;
    }

    public GetMatchHistory setStartAtMatchId(long startAtMatchId) {
        parameters.put(START_AT_MATCH_ID, startAtMatchId + "");
        return this;
    }

    public GetMatchHistory setMatchesRequested(int matchesRequested) {
        parameters.put(MATCHES_REQUESTED, matchesRequested + "");
        return this;
    }

    public GetMatchHistory setTournamentGamesOnly(Boolean tournamentGamesOnly) {
        parameters.put(TOURNAMENT_GAMES_ONLY, tournamentGamesOnly ? "1" : "0");
        return this;
    }

    public MatchHistory excute() throws WrongUrlException{
        TreeNode resultNode = getResultNode();
        MatchHistory matchHistory = null;
        try {
            matchHistory = mapper.treeToValue(resultNode, MatchHistory.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return matchHistory;
    }
}
