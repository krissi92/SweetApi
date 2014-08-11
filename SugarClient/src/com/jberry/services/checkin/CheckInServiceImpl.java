package com.jberry.services.checkin;

import com.jberry.dto.CheckIn;
import com.jberry.dto.FoodTO;
import com.jberry.services.food.FoodService;
import com.jberry.services.food.FoodServiceFactory;
import com.jberry.services.foodto.FoodTOService;
import com.jberry.services.foodto.FoodTOServiceFactory;

import java.util.Map;

public class CheckInServiceImpl implements CheckInService {
    @Override
    public int calculateInsulin(double ratio, FoodTO[] foodMap, double bloodSugar, boolean exercise) {
        CheckIn checkInstance = new CheckIn();
        FoodService foodServ = FoodServiceFactory.getFoodService();

        double totalCarbs = 0.0;

        for (int i = 0;i < foodMap.length; i++) {
            String foodName = foodMap[i].getFoodName();
            double carbs = foodServ.getCarbsFromFood(foodName);

            double grams = foodMap[i].getGrams();
            carbs = (carbs/100) * grams;

            totalCarbs = totalCarbs + carbs;
        }

        double unitsPerRatio = totalCarbs/ratio;
        double bloodSugarCorrection = (bloodSugar - checkInstance.getTargetBloodSugar())/checkInstance.getSensitivity();
        float bloodSugarLeftInBlood = (float) (1.0 - (checkInstance.getTimeSinceLast() * 0.25)) * checkInstance.getLastTimeUnits(); //active units

        double units = (unitsPerRatio + bloodSugarCorrection) - bloodSugarLeftInBlood;
        if (exercise){
            units = units * 0.5;
        }

        int insulin = (int) Math.round(units);

        checkInstance.setLastTimeUnits(insulin);

        return insulin;
    }
}