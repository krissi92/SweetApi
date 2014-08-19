package com.jberry.services.food;

import com.jberry.dto.Food;

import java.io.IOException;
import java.util.ArrayList;

public interface FoodService {
    ArrayList<String> getFoodTitle(String foodName);
    double getTotalCarbsFromFood(String Food);
    double getTotalFatFromFood(String foodName);
    double getTotalProteinsFromFood(String foodName);
    double getTotalSugarFromFood(String foodName);
    double getTotalCholesterolFromFood(String foodName);
    double getTotalFiberFromFood(String foodName);
    ArrayList<Food> getFoodInformation(String foodName) throws IOException;
}