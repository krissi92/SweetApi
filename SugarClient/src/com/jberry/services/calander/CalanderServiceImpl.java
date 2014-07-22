package com.jberry.services.calander;

import com.jberry.dto.CalanderMeal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Krissi on 21.7.2014.
 */
public class CalanderServiceImpl implements CalanderService {

    public List<CalanderMeal>getMealsByDay() throws ParseException {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd/HH");
        String sampleDate = "2014/07/03/";

        List<CalanderMeal> mealList = new ArrayList<CalanderMeal>() {
        };

        for(int i = 0; i<=24; i++){
            CalanderMeal temp = new CalanderMeal();
            String tString = "";
            temp.mealName = Integer.toString(i);
            if(i < 10){
                //String tS = Integer.toString(i);
                tString = "0" + i;
            }
            else {
                tString = Integer.toString(i);
            }
            Date d = ft.parse(sampleDate+tString);
            temp.timeOfMeal= ft.format(d);

            temp.userId = 1;
            mealList.add(i,temp);

            }
        return mealList;
    }
}
