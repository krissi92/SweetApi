package com.jberry.dto;

import java.util.List;

public class Meal {
    private String mealId;
    private String userId;
    private String MealName;

    //Setters
    public void setMealId(String mealId) {
        this.mealId = mealId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setMealName(String mealName) {
        MealName = mealName;
    }

    //Getters
    public String getMealId() {
        return mealId;
    }
    public String getUserId() {
        return userId;
    }
    public String getMealName() {
        return MealName;
    }
}