package com.jberry.dto;

import java.util.ArrayList;

public class Meal {
    private String mealId;
    private String userId;
    private String mealName;
    private ArrayList<FoodTO> ingredients;
    private double totalFat;
    private double totaCarbs;
    private double totalSugar;
    private double totalFiber;
    private double totalProtein;
    private double totalCholesterol;

    //Setters
    public void setMealId(String mealId) {
        this.mealId = mealId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setMealName(String mealName) {
        mealName = mealName;
    }
    public void setIngredients(ArrayList<FoodTO> ingredients) {
        this.ingredients = ingredients;
    }
    public void setTotalFat(double totalFat) {
        this.totalFat = totalFat;
    }
    public void setTotaCarbs(double totaCarbs) {
        this.totaCarbs = totaCarbs;
    }
    public void setTotalSugar(double totalSugar) {
        this.totalSugar = totalSugar;
    }
    public void setTotalFiber(double totalFiber) {
        this.totalFiber = totalFiber;
    }
    public void setTotalProtien(double totalProtien) {
        this.totalProtein = totalProtien;
    }
    public void setTotalCholesterol(double totalCholesterol) {
        this.totalCholesterol = totalCholesterol;
    }

    //Getters
    public String getMealId() {
        return mealId;
    }
    public String getUserId() {
        return userId;
    }
    public String getMealName() {
        return mealName;
    }
    public ArrayList<FoodTO> getIngredients() {
        return ingredients;
    }
    public double getTotalFat() {
        return totalFat;
    }
    public double getTotaCarbs() {
        return totaCarbs;
    }
    public double getTotalSugar() {
        return totalSugar;
    }
    public double getTotalFiber() {
        return totalFiber;
    }
    public double getTotalProtien() {
        return totalProtein;
    }
    public double getTotalCholesterol() {
        return totalCholesterol;
    }
}