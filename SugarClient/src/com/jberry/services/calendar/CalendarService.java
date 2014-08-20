package com.jberry.services.calendar;

import java.io.IOException;
import java.util.ArrayList;
import com.jberry.dto.CalanderMeal;

public interface CalendarService {
    boolean saveMealToCalander(String mealName, long timeStamp) throws IOException;
    ArrayList<CalanderMeal> getMealsByDay(long timeStamp) throws IOException;
}
