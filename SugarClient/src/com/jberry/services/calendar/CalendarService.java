package com.jberry.services.calendar;

import java.util.List;
import com.jberry.dto.CalanderMeal;

public interface CalendarService {

    List<CalanderMeal>getMealsByDay();
}
