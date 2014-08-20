package com.jberry.services.insulin;

import com.jberry.dto.FoodTO;
import java.io.IOException;
import java.util.ArrayList;

public interface InsulinService {
    double calculateInsulin(long timeStamp, ArrayList<FoodTO> foodMap, double bloodSugar, boolean exercise) throws IOException;
}
