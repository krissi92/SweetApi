package com.jberry.dto;

public class FoodTO {
    private String foodName;
    private int grams;

    //Constructor
    public FoodTO(String foodName, int grams) {
        this.foodName = foodName;
        this.grams = grams;
    }

    //Setters
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    public void setGrams(int grams) {
        this.grams = grams;
    }

    //Getters
    public String getFoodName() {
        return foodName;
    }
    public int getGrams() {
        return grams;
    }
}
