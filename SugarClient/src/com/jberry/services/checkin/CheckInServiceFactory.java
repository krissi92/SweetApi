package com.jberry.services.checkin;

public class CheckInServiceFactory {
    public static CheckInService getCheckInService() {
        Class c = null;
        try {
            c = Class.forName("com.jberry.services.checkin.CheckInServiceImpl");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        CheckInService checkInServiceInstance = null;
        try {
            checkInServiceInstance = (CheckInService)c.newInstance();

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
