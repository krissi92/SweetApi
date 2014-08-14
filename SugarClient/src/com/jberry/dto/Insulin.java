package com.jberry.dto;

public class Insulin {
    private double ratio;
    private double insulinSensitivity;
    private long timeStamp;
    private double totalcarbs;
    private double bloodsugar;
    private boolean excersise;
    private long lastDoseTime;      //TODO: serverside
    private double lastDoseAmount;  //TODO: serverside

    //Setters
    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
    public void setTotalcarbs(double totalcarbs) {
        this.totalcarbs = totalcarbs;
    }
    public void setBloodsugar(double bloodsugar) {
        this.bloodsugar = bloodsugar;
    }
    public void setExcersise(boolean excersise) {
        this.excersise = excersise;
    }
    public void setLastDoseAmount(double lastDoseAmount) {
        this.lastDoseAmount = lastDoseAmount;
    }
    public void setLastDoseTime(long lastDoseTime) {
        this.lastDoseTime = lastDoseTime;
    }
    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
    public void setInsulinSensitivity(double insulinSensitivity) {
        this.insulinSensitivity = insulinSensitivity;
    }

    //Getters
    public long getTimeStamp() {
        return timeStamp;
    }
    public double getTotalcarbs() {
        return totalcarbs;
    }
    public double getBloodsugar() {
        return bloodsugar;
    }
    public boolean isExcersise() {
        return excersise;
    }
    public long getLastDoseTime() {
        return lastDoseTime;
    }
    public double getLastDoseAmount() {
        return lastDoseAmount;
    }
    public double getRatio() {
        return ratio;
    }
    public double getInsulinSensitivity() {
        return insulinSensitivity;
    }
}
