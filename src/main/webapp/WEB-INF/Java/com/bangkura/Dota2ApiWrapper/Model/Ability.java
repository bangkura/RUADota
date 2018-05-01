package com.bangkura.Dota2ApiWrapper.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ability {
    private int ability;
    private int time;
    private int level;

    public int getAbility() {
        return ability;
    }

    public int getTime() {
        return time;
    }

    public int getLevel() {
        return level;
    }

    public void setAbility(int ability) {
        this.ability = ability;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "ability: " + getAbility() + "\n level: " + getLevel() + "\n time: " + getTime() + "\n";
    }
}
