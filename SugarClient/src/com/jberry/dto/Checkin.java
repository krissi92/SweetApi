package com.jberry.dto;

/**
 * Created by regnbogasulta on 21.7.2014.
 */
public class Checkin {
    public double ratio = 10;                     //Getur breyst milli tíma dags.
    public double morningRatio = 12;              //Breytist í stillingum
    public double noonRatio = 15;                 //Breytist í stillingum
    public double eveningRatio = 17;              //Breytist í stillingum
    public double bloodSugar = 0;                 //Hvað er blóðsykurinn hár núna.
    public final double targetBloodSugar = 6.5;   //target blodsykur, constant
    public double sensitivity = 2.75;             //Reyknað útfrá þyngd notanda.
    public float  lastTimeUnits = 5;              //hversu mikið af insúlíni þú sprautaðir sýðast.
    public float  timeSinceLast = 4;              //tími frá því síðasta checkin gerðist
}

