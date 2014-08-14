package com.jberry.services.insulin;

import com.jberry.dto.FoodTO;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface InsulinService {
    public double calculateInsulin(long timeStamp, FoodTO[] foodMap, double bloodSugar, boolean exercise) throws IOException;
}
