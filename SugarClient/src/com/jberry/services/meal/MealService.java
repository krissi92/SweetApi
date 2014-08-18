package com.jberry.services.meal;

import com.jberry.dto.FoodTO;
import com.jberry.dto.Meal;

import java.io.IOException;
import java.util.ArrayList;

public interface MealService {
    public boolean createMeal(String mealName, ArrayList<FoodTO> ingredients) throws IOException;
    public Meal getMealById(String mealId) throws IOException;
    public ArrayList<Meal> getMealsByUserId() throws IOException;
    public boolean editMeal(String mealId);

}
