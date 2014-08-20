package com.jberry.dto;

public class Insulin {
    private long timeStamp;
    private double totalCarbs;
    private double bloodSugar;
    private boolean excersise;

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
}
