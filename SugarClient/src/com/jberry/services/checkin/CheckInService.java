package com.jberry.services.checkin;

public interface CheckInService {
    int calculateInsulin(double ratio, String foodName, int gramms, double bloodsuger, boolean hreyfing);
}
