package com.jberry.services.diabetic;

import com.jberry.dto.Diabetic;

/**
 * Created by Krissi on 6.8.2014.
 */
public interface DiabeticService {

    Diabetic getDiabeticInfo(String diabeticId);
    Diabetic postDiabeticInfo(Diabetic object);

    Diabetic getRatio(String diabeticId);
    Diabetic postRatio(Double morning, Double noon, Double evening);
}
