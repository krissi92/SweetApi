package com.jberry.services.insulin;

public class InsulinServiceFactory {
    public static InsulinService getInsulinService() {
        Class c = null;
        try {
            c = Class.forName("com.jberry.services.insulin.InsulinServiceImpl");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        InsulinService insulinServiceInstance = null;
        try {
            insulinServiceInstance = (InsulinService) c.newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return insulinServiceInstance;
    }
}
