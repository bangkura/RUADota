package com.bangkura.Dota2ApiWrapper.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Player {
    private long account_id;
    private int player_slot;
    private int hero_id;
    private int item_0;
    private int item_1;
    private int item_2;
    private int item_3;
    private int item_4;
    private int item_5;

    private int backpack_0;
    private int backpack_1;
    private int backpack_2;
    private int kills;
    private int deaths;
    private int assists;
    private boolean leaver_status;
    private int last_hits;
    private int denies;
    private int gold_per_min;
    private int xp_per_min;
    private int level;
    private int hero_damage;
    private int tower_damage;
    private int hero_healing;
    private int gold;
    private int gold_spent;
    private int scaled_hero_damage;
    private int scaled_tower_damage;
    private int scaled_hero_healing;
    private ArrayList<Ability> ability_upgrades;

    public long getAccount_id() {
        return account_id;
    }

    public int getPlayer_slot() {
        return player_slot;
    }

    public int getHero_id() {
        return hero_id;
    }

    public int getItem_0() {
        return item_0;
    }

    public int getItem_1() {
        return item_1;
    }

    public int getItem_2() {
        return item_2;
    }

    public int getItem_3() {
        return item_3;
    }

    public int getItem_4() {
        return item_4;
    }

    public int getItem_5() {
        return item_5;
    }

    public int getBackpack_0() {
        return backpack_0;
    }

    public int getBackpack_1() {
        return backpack_1;
    }

    public int getBackpack_2() {
        return backpack_2;
    }

    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getAssists() {
        return assists;
    }

    public boolean isLeaver_status() {
        return leaver_status;
    }

    public int getLast_hits() {
        return last_hits;
    }

    public int getDenies() {
        return denies;
    }

    public int getGold_per_min() {
        return gold_per_min;
    }

    public int getXp_per_min() {
        return xp_per_min;
    }

    public int getLevel() {
        return level;
    }

    public int getHero_damage() {
        return hero_damage;
    }

    public int getTower_damage() {
        return tower_damage;
    }

    public int getHero_healing() {
        return hero_healing;
    }

    public int getGold() {
        return gold;
    }

    public int getGold_spent() {
        return gold_spent;
    }

    public int getScaled_hero_damage() {
        return scaled_hero_damage;
    }

    public int getScaled_tower_damage() {
        return scaled_tower_damage;
    }

    public int getScaled_hero_healing() {
        return scaled_hero_healing;
    }

    public ArrayList<Ability> getAbility_upgrades() {
        return ability_upgrades;
    }

    public void setAccount_id(long account_id) {
        this.account_id = account_id;
    }

    public void setPlayer_slot(int player_slot) {
        this.player_slot = player_slot;
    }

    public void setHero_id(int hero_id) {
        this.hero_id = hero_id;
    }

    public void setItem_0(int item_0) {
        this.item_0 = item_0;
    }

    public void setItem_1(int item_1) {
        this.item_1 = item_1;
    }

    public void setItem_2(int item_2) {
        this.item_2 = item_2;
    }

    public void setItem_3(int item_3) {
        this.item_3 = item_3;
    }

    public void setItem_4(int item_4) {
        this.item_4 = item_4;
    }

    public void setItem_5(int item_5) {
        this.item_5 = item_5;
    }

    public void setBackpack_0(int backpack_0) {
        this.backpack_0 = backpack_0;
    }

    public void setBackpack_1(int backpack_1) {
        this.backpack_1 = backpack_1;
    }

    public void setBackpack_2(int backpack_2) {
        this.backpack_2 = backpack_2;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setLeaver_status(boolean leaver_status) {
        this.leaver_status = leaver_status;
    }

    public void setLast_hits(int last_hits) {
        this.last_hits = last_hits;
    }

    public void setDenies(int denies) {
        this.denies = denies;
    }

    public void setGold_per_min(int gold_per_min) {
        this.gold_per_min = gold_per_min;
    }

    public void setXp_per_min(int xp_per_min) {
        this.xp_per_min = xp_per_min;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHero_damage(int hero_damage) {
        this.hero_damage = hero_damage;
    }

    public void setTower_damage(int tower_damage) {
        this.tower_damage = tower_damage;
    }

    public void setHero_healing(int hero_healing) {
        this.hero_healing = hero_healing;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setGold_spent(int gold_spent) {
        this.gold_spent = gold_spent;
    }

    public void setScaled_hero_damage(int scaled_hero_damage) {
        this.scaled_hero_damage = scaled_hero_damage;
    }

    public void setScaled_tower_damage(int scaled_tower_damage) {
        this.scaled_tower_damage = scaled_tower_damage;
    }

    public void setScaled_hero_healing(int scaled_hero_healing) {
        this.scaled_hero_healing = scaled_hero_healing;
    }

    public void setAbility_upgrades(ArrayList<Ability> ability_upgrades) {
        this.ability_upgrades = ability_upgrades;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ability_upgrades: ");
        for(Ability a: getAbility_upgrades()) {
            builder.append(a);
        }
        return builder.toString();
    }
}
