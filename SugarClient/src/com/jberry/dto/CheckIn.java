package com.jberry.dto;

public class CheckIn {
    public double bloodSugar = 0;                 //Hvað er blóðsykurinn hár núna.
    public final double targetBloodSugar = 6.5;   //target blodsykur, constant
    public double sensitivity = 2.75;             //Reyknað útfrá þyngd notanda.
    public float lastTimeUnits = 5;               //hversu mikið af insúlíni þú sprautaðir sýðast.
    public float timeSinceLast = 4;               //tími frá því síðasta checkin gerðist
}