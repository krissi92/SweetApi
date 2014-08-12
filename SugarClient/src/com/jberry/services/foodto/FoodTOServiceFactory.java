package com.jberry.services.foodto;

public class FoodTOServiceFactory {
    public static FoodTOService getFoodTOService() {
        Class c = null;
        try {
            c = Class.forName("com.jberry.services.foodto.FoodTOServiceImpl");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        FoodTOService foodtoServiceInstance = null;
        try {
            foodtoServiceInstance = (FoodTOService) c.newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return foodtoServiceInstance;
    }
}
