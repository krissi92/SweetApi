package com.jberry.services.calendar;

import com.jberry.dto.CalanderMeal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class CalendarServiceImpl implements CalendarService {

    public List<CalanderMeal>getMealsByDay(Long unixTimestamp) {
        //SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        long unixSeconds = unixTimestamp;

        List<CalanderMeal> mealList = new ArrayList<CalanderMeal>() {
        };

        for(int i = 0; i<=23; i++) {
            CalanderMeal calmeal = new CalanderMeal();
            calmeal.setMealName("BANANASALAT");
            calmeal.setTimeOfMeal(unixSeconds);
            calmeal.setUserId("1");
            mealList.add(i, calmeal);
            unixSeconds += 3600;

        }
        return mealList;
    }


}
