package com.jberry.dto;

public class Insulin {
    //private double insulinSensitivity;
    private long timeStamp;
    private double totalCarbs;
    private double bloodSugar;
    private boolean excersise;
    //private long lastDoseTime;      //TODO: serverside
    //private double lastDoseAmount;  //TODO: serverside

    //Setters
    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
    public void setTotalCarbs(double totalcarbs) {
        this.totalCarbs = totalcarbs;
    }
    public void setBloodSugar(double bloodsugar) {
        this.bloodSugar = bloodsugar;
    }
    public void setExcersise(boolean excersise) {
        this.excersise = excersise;
    }
    /*public void setLastDoseAmount(double lastDoseAmount) {
        this.lastDoseAmount = lastDoseAmount;
    }
    public void setLastDoseTime(long lastDoseTime) {
        this.lastDoseTime = lastDoseTime;
    }
    public void setInsulinSensitivity(double insulinSensitivity) {
        this.insulinSensitivity = insulinSensitivity;
    }*/

    //Getters
    public long getTimeStamp() {
        return timeStamp;
    }
    public double getTotalCarbs() {
        return totalCarbs;
    }
    public double getBloodSugar() {
        return bloodSugar;
    }
    public boolean isExcersise() {
        return excersise;
    }
    /*public long getLastDoseTime() {
        return lastDoseTime;
    }
    public double getLastDoseAmount() {
        return lastDoseAmount;
    }
    public double getInsulinSensitivity() {
        return insulinSensitivity;
    }*/
}
