package com.jberry.services.checkin;

import com.jberry.dto.CheckIn;
import com.jberry.services.food.FoodService;
import com.jberry.services.food.FoodServiceFactory;

import java.util.Map;

public class CheckInServiceImpl implements CheckInService {

    @Override
    public int calculateInsulin(double ratio, Map<String, Integer> foodMap, double bloodSugar, boolean exercise) {
        CheckIn checkInstance = new CheckIn();
        FoodService foodServ = FoodServiceFactory.getFoodService();
        //get stuff from food
        double totalCarbs = 0.0;

        for (Map.Entry<String, Integer> entry : foodMap.entrySet()) {
            String foodName = entry.getKey();
            double carbs = foodServ.getCarbsFromFood(foodName);

            Integer grams = entry.getValue();
            carbs = (carbs/100) * grams;

            totalCarbs = totalCarbs + carbs;
        }

        double unitsPerRatio = totalCarbs/ratio;
        double bloodSugarCorrection = (bloodSugar - checkInstance.targetBloodSugar)/checkInstance.sensitivity;
        float bloodSugarLeftInBlood = (float) (1.0 - (checkInstance.timeSinceLast * 0.25)) * checkInstance.lastTimeUnits; //active units

        double units = (unitsPerRatio + bloodSugarCorrection) - bloodSugarLeftInBlood;
        if (exercise){
            units = units * 0.5;
        }

        return ((int) Math.round(units));
    }
}