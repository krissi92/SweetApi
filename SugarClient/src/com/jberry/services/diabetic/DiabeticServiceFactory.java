package com.jberry.services.diabetic;

public class DiabeticServiceFactory {
    public static DiabeticService getDiabeticService() {
        Class c = null;
        try {
            c = Class.forName("com.jberry.services.diabetic.DiabeticService");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        DiabeticService diabeticServiceInstance = null;
        try {
            diabeticServiceInstance = (DiabeticService) c.newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return diabeticServiceInstance;
    }
}
