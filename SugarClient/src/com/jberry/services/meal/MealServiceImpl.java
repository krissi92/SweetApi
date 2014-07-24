package com.jberry.services.meal;

import com.jberry.dto.Food;
import com.jberry.dto.Meal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Krissi on 23.7.2014.
 */
public class MealServiceImpl implements MealService{


    @Override
    public Meal getMealByName() {

        //búa til BANANASALAT
        Meal BananaSalat = new Meal();
        //BananaSalat.Ingredients = new Hashtable();
        BananaSalat.MealName = "BANANASALAT";
        BananaSalat.Ingredients = new HashMap<String, Integer>();
        BananaSalat.Ingredients.put("BANANI", 10);
        BananaSalat.Ingredients.put("EPLI", 5);
        BananaSalat.Ingredients.put("MANGO", 2);
        BananaSalat.Meald = 1;
        //Alls shittið
        BananaSalat.AlkóhólAlls = 1337;
        BananaSalat.AvítamínAlls = 1337;
        BananaSalat.B12vítamínAlls = 1337;
        BananaSalat.B1vítamínAlls = 1337;
        BananaSalat.B2vítaminAlls = 1337;
        BananaSalat.CvítamínAlls = 1337;
        BananaSalat.DVítamínAlls = 1337;
        BananaSalat.EVítamínAlls = 1337;
        BananaSalat.FitaAlls = 1337;
        BananaSalat.KalkAlls = 1337;
        BananaSalat.KolvetniAlls = 1337;
        BananaSalat.KólesterólAlls = 1337;
        BananaSalat.MettaðarfitusýrurAlls = 1337;
        BananaSalat.PróteinAlls = 1337;
        BananaSalat.SteinefniAlls = 1337;
        BananaSalat.TrefjaefniAlls = 1337;
        BananaSalat.ViðbætturSykurAlls = 1337;
        //með banana, epli og mango
        //setja það í meal object og skila því



        return BananaSalat;
    }
}
