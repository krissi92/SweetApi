package com.jberry.dto;

import java.util.HashMap;
import java.util.Map;

public class Meal {
    private int Meald;
    //public HashMap<String, Integer> Ingredients; //TODO: make not a map
    public FoodTO[] Ingredients;
    private String MealName;
    //ALLS  hluti
    private double PróteinAlls;
    private double FitaAlls;
    private double MettaðarfitusýrurAlls;
    private double KólesterólAlls;
    private double KolvetniAlls;
    private double ViðbætturSykurAlls;
    private double TrefjaefniAlls;
    private double AlkóhólAlls;
    private double SteinefniAlls;
    private double AvítamínAlls;
    private double DVítamínAlls;
    private double EVítamínAlls;
    private double B1vítamínAlls;
    private double B2vítaminAlls;
    private double B12vítamínAlls;
    private double CvítamínAlls;
    private double KalkAlls;

    //Getters
    public int getMeald() {
        return Meald;
    }
    /*public HashMap<String, Integer> getIngredients() {
        return Ingredients;
    }*/
    public String getMealName() {
        return MealName;
    }
    public double getPróteinAlls() {
        return PróteinAlls;
    }
    public double getFitaAlls() {
        return FitaAlls;
    }
    public double getMettaðarfitusýrurAlls() {
        return MettaðarfitusýrurAlls;
    }
    public double getKólesterólAlls() {
        return KólesterólAlls;
    }
    public double getKolvetniAlls() {
        return KolvetniAlls;
    }
    public double getViðbætturSykurAlls() {
        return ViðbætturSykurAlls;
    }
    public double getTrefjaefniAlls() {
        return TrefjaefniAlls;
    }
    public double getAlkóhólAlls() {
        return AlkóhólAlls;
    }
    public double getSteinefniAlls() {
        return SteinefniAlls;
    }
    public double getAvítamínAlls() {
        return AvítamínAlls;
    }
    public double getDVítamínAlls() {
        return DVítamínAlls;
    }
    public double getEVítamínAlls() {
        return EVítamínAlls;
    }
    public double getB1vítamínAlls() {
        return B1vítamínAlls;
    }
    public double getB2vítaminAlls() {
        return B2vítaminAlls;
    }
    public double getB12vítamínAlls() {
        return B12vítamínAlls;
    }
    public double getCvítamínAlls() {
        return CvítamínAlls;
    }
    public double getKalkAlls() {
        return KalkAlls;
    }

    //Setters
    public void setMeald(int meald) {
        Meald = meald;
    }
    /*public void setIngredients(HashMap<String, Integer> ingredients) {
        Ingredients = ingredients;
    }*/
    public void setMealName(String mealName) {
        MealName = mealName;
    }
    public void setPróteinAlls(double próteinAlls) {
        PróteinAlls = próteinAlls;
    }
    public void setFitaAlls(double fitaAlls) {
        FitaAlls = fitaAlls;
    }
    public void setMettaðarfitusýrurAlls(double mettaðarfitusýrurAlls) {
        MettaðarfitusýrurAlls = mettaðarfitusýrurAlls;
    }
    public void setKólesterólAlls(double kólesterólAlls) {
        KólesterólAlls = kólesterólAlls;
    }
    public void setKolvetniAlls(double kolvetniAlls) {
        KolvetniAlls = kolvetniAlls;
    }
    public void setViðbætturSykurAlls(double viðbætturSykurAlls) {
        ViðbætturSykurAlls = viðbætturSykurAlls;
    }
    public void setTrefjaefniAlls(double trefjaefniAlls) {
        TrefjaefniAlls = trefjaefniAlls;
    }
    public void setAlkóhólAlls(double alkóhólAlls) {
        AlkóhólAlls = alkóhólAlls;
    }
    public void setSteinefniAlls(double steinefniAlls) {
        SteinefniAlls = steinefniAlls;
    }
    public void setAvítamínAlls(double avítamínAlls) {
        AvítamínAlls = avítamínAlls;
    }
    public void setDVítamínAlls(double DVítamínAlls) {
        this.DVítamínAlls = DVítamínAlls;
    }
    public void setEVítamínAlls(double EVítamínAlls) {
        this.EVítamínAlls = EVítamínAlls;
    }
    public void setB1vítamínAlls(double b1vítamínAlls) {
        B1vítamínAlls = b1vítamínAlls;
    }
    public void setB2vítaminAlls(double b2vítaminAlls) {
        B2vítaminAlls = b2vítaminAlls;
    }
    public void setB12vítamínAlls(double b12vítamínAlls) {
        B12vítamínAlls = b12vítamínAlls;
    }
    public void setCvítamínAlls(double cvítamínAlls) {
        CvítamínAlls = cvítamínAlls;
    }
    public void setKalkAlls(double kalkAlls) {
        KalkAlls = kalkAlls;
    }
}