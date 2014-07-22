package com.jberry.services.calander;

public class CalanderServiceFactory {
    public static CalanderService getCalanderService() {
        Class c = null;
        try {
            c = Class.forName("com.jberry.services.calander.CalanderServiceImpl");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        CalanderService calanderServiceInstance = null;
        try {
            calanderServiceInstance = (CalanderService) c.newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return calanderServiceInstance;
    }
}
