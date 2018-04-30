package com.bangkura.Dota2ApiWrapper.Model;

public class Item {
    private int id;
    private String name;
    private int cost;
    private boolean secret_shop;
    private boolean side_shop;
    private boolean recipe;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public boolean isSecret_shop() {
        return secret_shop;
    }

    public boolean isSide_shop() {
        return side_shop;
    }

    public boolean isRecipe() {
        return recipe;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setSecret_shop(boolean secret_shop) {
        this.secret_shop = secret_shop;
    }

    public void setSide_shop(boolean side_shop) {
        this.side_shop = side_shop;
    }

    public void setRecipe(boolean recipe) {
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return "The item id: " + id + ", name: " + name + ", isSecret_shop: " + secret_shop + ", is side: " + side_shop;
    }
}
