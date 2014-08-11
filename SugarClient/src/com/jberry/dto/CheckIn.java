package com.jberry.dto;

public class CheckIn {
    private double bloodSugar;                      //Hvað er blóðsykurinn hár núna.
    private final double targetBloodSugar = 6.5;    //target blodsykur, constant
    private double sensitivity;                     //Reyknað útfrá þyngd notanda.
    private int lastTimeUnits;                      //hversu mikið af insúlíni þú sprautaðir sýðast.
    private long timeSinceLast;                     //tími frá því síðasta checkin gerðist TODO: þarf að vera breytt.

    //Setters
    public void setLastTimeUnits(int lastTimeUnits) {
        this.lastTimeUnits = lastTimeUnits;
    }
    public void setTimeSinceLast(long timeSinceLast) { this.timeSinceLast = timeSinceLast; }
    //Getters
    public double getBloodSugar() {
        return bloodSugar;
    }
    public double getTargetBloodSugar() {
        return targetBloodSugar;
    }
    public double getSensitivity() {
        return sensitivity;
    }
    public float getLastTimeUnits() {
        return lastTimeUnits;
    }
    public float getTimeSinceLast() {
        return timeSinceLast;
    }
}