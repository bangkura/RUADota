package com.bangkura.Dota2ApiWrapper.Model;

import java.util.ArrayList;

public class MatchDetails {
    private ArrayList<Player> players;
    private boolean radiant_win;
    private int duration;
    private long pre_game_duration;
    private long start_time;
    private long match_id;
    private long match_seq_num;
    private int tower_status_radiant;
    private int tower_status_dire;
    private int barracks_status_radiant;
    private int barracks_status_dire;
    private int cluster;
    private int first_blood_time;
    private int lobby_type;
    private int human_players;
    private int leagueid;
    private int positive_votes;
    private int negative_votes;
    private int game_mode;
    private int flags;
    private int engine;
    private int radiant_score;
    private int dire_score;

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public boolean isRadiant_win() {
        return radiant_win;
    }

    public int getDuration() {
        return duration;
    }

    public long getPre_game_duration() {
        return pre_game_duration;
    }

    public long getStart_time() {
        return start_time;
    }

    public long getMatch_id() {
        return match_id;
    }

    public long getMatch_seq_num() {
        return match_seq_num;
    }

    public int getTower_status_radiant() {
        return tower_status_radiant;
    }

    public int getTower_status_dire() {
        return tower_status_dire;
    }

    public int getBarracks_status_radiant() {
        return barracks_status_radiant;
    }

    public int getBarracks_status_dire() {
        return barracks_status_dire;
    }

    public int getCluster() {
        return cluster;
    }

    public int getFirst_blood_time() {
        return first_blood_time;
    }

    public int getLobby_type() {
        return lobby_type;
    }

    public int getHuman_players() {
        return human_players;
    }

    public int getLeagueid() {
        return leagueid;
    }

    public int getPositive_votes() {
        return positive_votes;
    }

    public int getNegative_votes() {
        return negative_votes;
    }

    public int getGame_mode() {
        return game_mode;
    }

    public int getFlags() {
        return flags;
    }

    public int getEngine() {
        return engine;
    }

    public int getRadiant_score() {
        return radiant_score;
    }

    public int getDire_score() {
        return dire_score;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void setRadiant_win(boolean radiant_win) {
        this.radiant_win = radiant_win;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setPre_game_duration(long pre_game_duration) {
        this.pre_game_duration = pre_game_duration;
    }

    public void setStart_time(long start_time) {
        this.start_time = start_time;
    }

    public void setMatch_id(long match_id) {
        this.match_id = match_id;
    }

    public void setMatch_seq_num(long match_seq_num) {
        this.match_seq_num = match_seq_num;
    }

    public void setTower_status_radiant(int tower_status_radiant) {
        this.tower_status_radiant = tower_status_radiant;
    }

    public void setTower_status_dire(int tower_status_dire) {
        this.tower_status_dire = tower_status_dire;
    }

    public void setBarracks_status_radiant(int barracks_status_radiant) {
        this.barracks_status_radiant = barracks_status_radiant;
    }

    public void setBarracks_status_dire(int barracks_status_dire) {
        this.barracks_status_dire = barracks_status_dire;
    }

    public void setCluster(int cluster) {
        this.cluster = cluster;
    }

    public void setFirst_blood_time(int first_blood_time) {
        this.first_blood_time = first_blood_time;
    }

    public void setLobby_type(int lobby_type) {
        this.lobby_type = lobby_type;
    }

    public void setHuman_players(int human_players) {
        this.human_players = human_players;
    }

    public void setLeagueid(int leagueid) {
        this.leagueid = leagueid;
    }

    public void setPositive_votes(int positive_votes) {
        this.positive_votes = positive_votes;
    }

    public void setNegative_votes(int negative_votes) {
        this.negative_votes = negative_votes;
    }

    public void setGame_mode(int game_mode) {
        this.game_mode = game_mode;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public void setEngine(int engine) {
        this.engine = engine;
    }

    public void setRadiant_score(int radiant_score) {
        this.radiant_score = radiant_score;
    }

    public void setDire_score(int dire_score) {
        this.dire_score = dire_score;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("players: ");
        for(Player p: getPlayers()) {
            builder.append(p);
        }
        builder.append("\n" + "radiant_win: " + isRadiant_win());
        return builder.toString();
    }
}
