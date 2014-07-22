package com.jberry.services.Checkin;

/**
 * Created by regnbogasulta on 22.7.2014.
 */
public class CheckInServiceFactory {
    public static CheckInService getCheckinService() {
        Class b = null;
        try {
            b = Class.forName("com.jberry.services.checkin.CheckInImpl");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        CheckInService checkInServiceInstance = null;
        try {
            checkInServiceInstance = (CheckInService)b.newInstance();

        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return checkInServiceInstance;
    }
}
