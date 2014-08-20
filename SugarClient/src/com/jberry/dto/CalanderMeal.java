package com.jberry.dto;

public class CalanderMeal {
    private String mealName;
    private Long timeOfMeal;
    private String userId;

    //struct


    public CalanderMeal(String mealName, Long timeOfMeal) {
        this.mealName = mealName;
        this.timeOfMeal = timeOfMeal;
    }

    //setters
    public void setMealName(String mealName) {
        this.mealName = mealName;
    }
    public void setTimeOfMeal(Long timeOfMeal) {
        this.timeOfMeal = timeOfMeal;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    //getters
    public String getMealName() {
        return mealName;
    }
    public Long getTimeOfMeal() {
        return timeOfMeal;
    }
    public String getUserId() {
        return userId;
    }

}
