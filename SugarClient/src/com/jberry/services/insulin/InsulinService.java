package com.jberry.services.insulin;

import com.jberry.dto.FoodTO;

public interface InsulinService {
    public double calculateInsulin(long timeStamp, FoodTO[] foodMap, double bloodSugar, boolean exercise);
}
