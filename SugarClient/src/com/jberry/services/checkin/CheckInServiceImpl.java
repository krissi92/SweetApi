package com.jberry.services.checkin;

import com.jberry.dto.CheckIn;
import com.jberry.services.food.FoodService;
import com.jberry.services.food.FoodServiceFactory;

public class CheckInServiceImpl implements CheckInService {

    @Override
    public int calculateInsulin(double ratio, String foodName, int gramms, double bloodSugar, boolean exercise) {
        CheckIn checkInstance = new CheckIn();
        FoodService foodServ = FoodServiceFactory.getFoodService();
        //get stuff from food
        double carbs = foodServ.getCarbsFromFood(foodName);
        carbs = (carbs/100) * gramms;
        double unitsPerRatio = carbs/ratio;
        double bloodSugarCorrection = (bloodSugar - checkInstance.targetBloodSugar)/checkInstance.sensitivity;
        float bloodSugarLeftInBlood = (float) (1.0 - (checkInstance.timeSinceLast * 0.25)) * checkInstance.lastTimeUnits; //active units

        double units = (unitsPerRatio + bloodSugarCorrection) - bloodSugarLeftInBlood;
        if (exercise){
            units = units * 0.5;
        }

        return ((int) Math.round(units));
    }
}