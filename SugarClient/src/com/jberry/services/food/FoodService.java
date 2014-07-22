package com.jberry.services.food;

import com.jberry.dto.Food;

public interface FoodService {
    double getCarbsFromFood(String Food);
    double getCarbsTotalFromFood(String Food);
}