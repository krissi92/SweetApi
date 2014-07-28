package com.jberry.dto;

import java.util.Date;

public class CalanderMeal {
    private String mealName;
    private Long timeOfMeal;
    private int userId;

    //setters
    public void setMealName(String mealName) {
        this.mealName = mealName;
    }
    public void setTimeOfMeal(Long timeOfMeal) {
        this.timeOfMeal = timeOfMeal;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    //getters
    public String getMealName() {
        return mealName;
    }
    public Long getTimeOfMeal() {
        return timeOfMeal;
    }
    public int getUserId() {
        return userId;
    }

}
