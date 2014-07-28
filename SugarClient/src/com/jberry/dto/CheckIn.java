package com.jberry.dto;

public class CheckIn {
    private double bloodSugar = 0;                 //Hvað er blóðsykurinn hár núna.
    private final double targetBloodSugar = 6.5;   //target blodsykur, constant
    private double sensitivity = 2.75;             //Reyknað útfrá þyngd notanda.
    private int lastTimeUnits = 5;                 //hversu mikið af insúlíni þú sprautaðir sýðast.
    private float timeSinceLast = 4;               //tími frá því síðasta checkin gerðist TODO: þarf að vera breytt.

    //Setters
    public void setLastTimeUnits(int lastTimeUnits) {
        this.lastTimeUnits = lastTimeUnits;
    }
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