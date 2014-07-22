package com.jberry.services.calander;

import com.jberry.dto.CalanderMeal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class CalanderServiceImpl implements CalanderService {

    public List<CalanderMeal>getMealsByDay() {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        long unixSeconds = 1404342000;

        List<CalanderMeal> mealList = new ArrayList<CalanderMeal>() {
        };

        for(int i = 0; i<=23; i++) {
            unixSeconds += 3600;
            CalanderMeal temp = new CalanderMeal();
            temp.mealName = "BANANASALAT";
            Date d = new Date(unixSeconds*1000L);
            ft.setTimeZone(TimeZone.getTimeZone("GMT"));
            temp.timeOfMeal = ft.format(d);
            temp.userId = 1;
            mealList.add(i, temp);

        }
        return mealList;
    }
}
