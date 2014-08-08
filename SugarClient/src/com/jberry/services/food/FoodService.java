package com.jberry.services.food;

import com.jberry.dto.Food;

import java.io.IOException;
import java.util.ArrayList;

public interface FoodService {
    ArrayList<String> getFoodTitle(String foodName);
    double getCarbsFromFood(String Food);
    Food[] getFoodInformation(String foodName) throws IOException;

}