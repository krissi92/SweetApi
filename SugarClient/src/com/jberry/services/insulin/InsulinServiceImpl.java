package com.jberry.services.insulin;

import com.google.gson.Gson;
import com.jberry.dto.FoodTO;
import com.jberry.dto.Insulin;
import com.jberry.services.food.FoodService;
import com.jberry.services.food.FoodServiceFactory;

public class InsulinServiceImpl implements InsulinService {
    public double calculateInsulin(long timeStamp, FoodTO[] foodMap, double bloodSugar, boolean exercise) {
        Insulin insulinInstance = new Insulin();

        insulinInstance.setTimeStamp(timeStamp);
        insulinInstance.setTotalcarbs(sumObjectList(foodMap));
        insulinInstance.setBloodsugar(bloodSugar);
        insulinInstance.setExcersise(exercise);
        insulinInstance.setTimeStamp(timeStamp);

        String ans = makeJson(insulinInstance);

        System.out.println("Json: " + ans);


        //void fall(double ratio, double totalcarbs, double bloodsugar, boolean excersise);

        //svo er restinn gerð serverside.

        /*
        double unitsPerRatio = totalCarbs/ratio;
        double bloodSugarCorrection = (bloodSugar - checkInstance.getTargetBloodSugar())/checkInstance.getSensitivity();
        float bloodSugarLeftInBlood = (float) (1.0 - (checkInstance.getTimeSinceLast() * 0.25)) * checkInstance.getLastTimeUnits(); //active units

        double units = (unitsPerRatio + bloodSugarCorrection) - bloodSugarLeftInBlood;
        if (exercise){
            units = units * 0.5;
        }

        int insulin = (int) Math.round(units);

        checkInstance.setLastTimeUnits(insulin);

        return insulin;*/
        return 55;
    }

    private String makeJson(Insulin ins){
        Gson jesus = new Gson();
        jesus.toJson(ins);
        return jesus.toJson(ins);
    }

    private double sumObjectList(FoodTO[] foods){
        FoodService foodServ = FoodServiceFactory.getFoodService();

        double totalCarbs = 0.0;
        for (int i = 0; i < foods.length - 1; i++) {
            String foodName = foods[i].getFoodName();
            double carbs = foodServ.getCarbsFromFood(foodName);

            double grams = foods[i].getGrams();
            carbs = (carbs/100) * grams;

            totalCarbs += carbs;
        }
        return totalCarbs;
    }
}
