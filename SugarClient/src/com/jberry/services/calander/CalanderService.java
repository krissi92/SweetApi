package com.jberry.services.calander;

import java.text.ParseException;
import java.util.List;
import com.jberry.dto.CalanderMeal;

public interface CalanderService {

    List<CalanderMeal>getMealsByDay();
}
