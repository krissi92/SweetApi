package com.jberry.dto;

public class Diabetic {
    private double morningRatio;
    private double noonRatio;
    private double eveningRatio;
    private double insulinSensitivity;
    private long lastDoseTime;
    private double lastDoseAmount;

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
    public void setInsulinSensitivity(double insulinSensitivity) {
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
    public double getInsulinSensitivity() {
        return insulinSensitivity;
    }

    public long getLastDoseTime() {
        return lastDoseTime;
    }

    public void setLastDoseTime(long lastDoseTime) {
        this.lastDoseTime = lastDoseTime;
    }

    public double getLastDoseAmount() {
        return lastDoseAmount;
    }

    public void setLastDoseAmount(double lastDoseAmount) {
        this.lastDoseAmount = lastDoseAmount;
    }
}
