package com.jberry.services.meal;

import com.jberry.dto.Food;
import com.jberry.dto.Meal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class MealServiceImpl implements MealService{


    @Override
    public Meal getMealByName() {

        //búa til BANANASALAT
        Meal BananaSalat = new Meal();
        //BananaSalat.Ingredients = new Hashtable();
        BananaSalat.setMealName("BANANASALAT");


        BananaSalat.Ingredients = new HashMap<String, Integer>();
        BananaSalat.Ingredients.put("BANANI", 10);
        BananaSalat.Ingredients.put("EPLI", 5);
        BananaSalat.Ingredients.put("MANGO", 2);

        BananaSalat.setMeald(1);
        //Alls shittið
        BananaSalat.setAlkóhólAlls(1337);
        BananaSalat.setAvítamínAlls(1337);
        BananaSalat.setB12vítamínAlls(1337);
        BananaSalat.setB1vítamínAlls(1337);
        BananaSalat.setB2vítaminAlls(1337);
        BananaSalat.setCvítamínAlls(1337);
        BananaSalat.setDVítamínAlls(1337);
        BananaSalat.setEVítamínAlls(1337);
        BananaSalat.setFitaAlls(1337);
        BananaSalat.setKalkAlls(1337);
        BananaSalat.setKolvetniAlls(1337);
        BananaSalat.setKólesterólAlls(1337);
        BananaSalat.setMettaðarfitusýrurAlls(1337);
        BananaSalat.setPróteinAlls(1337);
        BananaSalat.setSteinefniAlls(1337);
        BananaSalat.setTrefjaefniAlls(1337);
        BananaSalat.setViðbætturSykurAlls(1337);
        //með banana, epli og mango
        //setja það í meal object og skila því

        return BananaSalat;
    }
}
