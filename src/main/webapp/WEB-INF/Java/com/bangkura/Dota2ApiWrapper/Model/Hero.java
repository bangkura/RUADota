package com.bangkura.Dota2ApiWrapper.Model;

public class Hero {
    String name;
    int id;
    String localized_name;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getLocalized_name() {
        return localized_name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLocalized_name(String localized_name) {
        this.localized_name = localized_name;
    }

    @Override
    public String toString() {
        return "The hero with id: " + id + ", name: " + name;
    }
}
