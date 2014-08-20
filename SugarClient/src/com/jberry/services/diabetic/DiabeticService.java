package com.jberry.services.diabetic;

import com.jberry.dto.Diabetic;
import java.io.IOException;

public interface DiabeticService {

    Diabetic getDiabeticInfo(String userId)throws IOException;
    boolean postDiabeticInfo(Diabetic DiabeticUsr) throws IOException;
    boolean finishCheckIn(Diabetic DiabeticUsr) throws IOException;
}
