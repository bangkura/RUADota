package com.bangkura.Dota2ApiWrapper.Model;

import java.util.Date;
import java.util.List;

public class Tick {
    private long time;
    private List<HeroEntity> heroEntities;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public List<HeroEntity> getHeroEntities() {
        return heroEntities;
    }

    public void setHeroEntities(List<HeroEntity> heroEntities) {
        this.heroEntities = heroEntities;
    }
}
