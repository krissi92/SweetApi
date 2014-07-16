package com.jberry.services.food;

public class FoodServiceFactory {
    public static FoodService getFoodService() {
        Class c = null;
        try {
            c = Class.forName("com.jberry.services.food.FoodServiceImpl");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        FoodService foodServiceInstance = null;
        try {
            foodServiceInstance = (FoodService) c.newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return foodServiceInstance;
    }
}
