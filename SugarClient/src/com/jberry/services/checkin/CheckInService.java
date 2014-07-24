package com.jberry.services.checkin;

import java.util.Map;

public interface CheckInService {
    int calculateInsulin(double ratio, Map<String, Integer> foodMap, double bloodSugar, boolean exercise);
}
