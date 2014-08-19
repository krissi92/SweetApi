package com.jberry.services.meal;

import com.jberry.dto.FoodTO;
import com.jberry.dto.Meal;

import java.io.IOException;
import java.util.ArrayList;

public interface MealService {
    boolean createMeal(String mealName, ArrayList<FoodTO> ingredients) throws IOException;
    Meal getMealByName(String mealName) throws IOException;
    ArrayList<Meal> getMealsByUserId() throws IOException;
    boolean deleteMeal(String mealName) throws IOException;
    boolean editMeal(String mealName, ArrayList<FoodTO> newIngredients) throws IOException;
}
