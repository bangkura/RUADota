package com.bangkura.Dota2ApiWrapper.Model;

import java.util.List;

public class Replay {
    List<Tick> ticks;

    public List<Tick> getTicks() {
        return ticks;
    }

    public void setTicks(List<Tick> ticks) {
        this.ticks = ticks;
    }
}
