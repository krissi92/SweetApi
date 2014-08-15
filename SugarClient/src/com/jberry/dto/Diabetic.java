package com.jberry.dto;

public class Diabetic {
    private double morningRatio;
    private double noonRatio;
    private double eveningRatio;
    private float insulinSensitivity;

    //Setters
    public void setMorningRatio(double morningRatio) {
        this.morningRatio = morningRatio;
    }
    public void setNoonRatio(double noonRatio) {
        this.noonRatio = noonRatio;
    }
    public void setEveningRatio(double eveningRatio) {
        this.eveningRatio = eveningRatio;
    }
    public void setInsulinSensitivity(float insulinSensitivity) {
        this.insulinSensitivity = insulinSensitivity;
    }

    //Getters
    public double getMorningRatio() {
        return morningRatio;
    }
    public double getNoonRatio() {
        return noonRatio;
    }
    public double getEveningRatio() {
        return eveningRatio;
    }
    public float getInsulinSensitivity() {
        return insulinSensitivity;
    }
}
