package com.jberry.services.food;

import com.jberry.dto.Food;

public class FoodServiceImpl implements FoodService {
    @Override
    public double getCarbsFromFood(String Food) {
        return 10.9;
    }

    @Override
    public Food getFoodInformation() {
        Food Banana = new Food();
        Banana.setId(1);
        Banana.setNafn("Banani");
        Banana.setName("Banana");
        Banana.setFæðuflokkur("Grænmeti og Ávextir");
        Banana.setAðalfl(6);
        Banana.setUndirfl(1);
        Banana.setÆturhluti(60);
        Banana.setPrótein(1.2);
        Banana.setFita(0.3);
        Banana.setMettaðarfitusýrur(0.1);
        Banana.setCisEinómettaðarfitusýrur(0.036);
        Banana.setCisFjölómettaðarfitusýrur(0.083);
        Banana.setCisFjölómettaðarfitusn3langar(0);
        Banana.setTransFitusýrur(0);
        Banana.setKólesteról(0);
        Banana.setKolvetni(20.2);
        Banana.setSykrur(13.1);
        Banana.setViðbættursykur(0);
        Banana.setTrefjaefni(1.8);
        Banana.setAlkohól(0);
        Banana.setSteinefnialls(0.8);
        Banana.setVatn(76);
        Banana.setAvítamínRJ(4.4);
        Banana.setRetinol(0);
        Banana.setBetakarótín(53);
        Banana.setDvítamín(0);
        Banana.setEvítamínalfaTJ(0.21);
        Banana.setB1vítamín(0.04);
        Banana.setB2vítamín(0.05);
        Banana.setNíasínjafngildi(0.9);
        Banana.setNíasín(0.7);
        Banana.setB6vítamín(0.299);
        Banana.setFólatalls(38);
        Banana.setB12vítamín(0);
        Banana.setCvítamín(11);
        Banana.setKalk(5);
        Banana.setFosfór(28);
        Banana.setMagnesíum(26);
        Banana.setNatríum(2);
        Banana.setKalíum(347);
        Banana.setJárn(0.35);
        Banana.setSink(0.18);
        Banana.setKopar(0.11);
        Banana.setJoð(0.4);
        Banana.setSelen(1.04);
        Banana.setCisFjölómettaðarfitusn3(0.048);
        Banana.setCisFjölómettaðarfitusn6(0.035);
        Banana.setTransfita(0);
        Banana.setSykur(0);
        Banana.setAvítamín(0);
        Banana.setEvítamín(0);

        return Banana;
    }
}
