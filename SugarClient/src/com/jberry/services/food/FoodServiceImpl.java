package com.jberry.services.food;

import com.jberry.dto.Food;

public class FoodServiceImpl implements FoodService {


    @Override
    public double getCarbsFromFood(String Food) {
        return 0;
    }

    @Override
    public double getCarbsTotalFromFood(String Food) {
        return 0;
    }

    @Override
    public Food getFoodInformation() {
        Food Banani = new Food();
        Banani.Nafn = "Banani";
        Banani.Name = "Banana";
        Banani.Fæðuflokkur = "Grænmeti og Ávextir";
        Banani.Aðalfl = "6";
        Banani.Undirfl = "1";
        Banani.Æturhluti = 60;
        Banani.Prótein = (float) 1.2;
        Banani.Fita = (float)0.3;
        Banani.Mettaðarfitusýrur = (float)0.1;
        Banani.cisEinómettaðarfitusýrur = (float)0.036;
        Banani.cisFjölómettaðarfitusýrur = (float)0.083;
        Banani.cisFjölómettaðarfitusn3langar = 0;
        Banani.transFitusýrur = 0;
        Banani.Kólesteról = 0;
        Banani.Kolvetni = (float)20.2;
        Banani.Sykrur = (float)13.1;
        Banani.Viðbættursykur = 0;
        Banani.Trefjaefni = (float)1.8;
        Banani.Alkohól = 0;
        Banani.Steinefnialls=(float)0.8;
        Banani.Vatn=(float)76;
        Banani.AvítamínRJ= (float) 4.4;
        Banani.Retinol=0;
        Banani.Betakarótín=(float)53;
        Banani.Dvítamín=0;
        Banani.EvítamínalfaTJ=(float)0.21;
        Banani.B1vítamín= (float)0.04;
        Banani.B2vítamín=(float)0.05;
        Banani.Níasínjafngildi=(float)0.9;
        Banani.Níasín = (float)0.7;
        Banani.B6vítamín=(float)0.299;
        Banani.Fólatalls=38;
        Banani.B12vítamín=0;
        Banani.Cvítamín = (float)11;
        Banani.Kalk = (float)5;
        Banani.Fosfór=(float)28;
        Banani.Magnesíum=26;
        Banani.Natríum=(float)2;
        Banani.Kalíum = 347;
        Banani.Járn=(float)0.35;
        Banani.Sink=(float)0.18;
        Banani.Kopar=(float)0.11;
        Banani.Joð=(float)0.4;
        Banani.Selen=(float)1.04;
        Banani.cisFjölómettaðarfitusn6= (float)0.035;
        Banani.cisFjölómettaðarfitusn3= (float)0.048;




        return Banani;
    }
}
