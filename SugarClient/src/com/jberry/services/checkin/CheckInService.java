package com.jberry.services.checkin;

import com.jberry.dto.FoodTO;

import java.util.Map;

public interface CheckInService {
    int calculateInsulin(double ratio, FoodTO[] foodMap, double bloodSugar, boolean exercise);
}
