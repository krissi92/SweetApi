package com.jberry.services.meal;

/**
 * Created by Krissi on 23.7.2014.
 */
public class MealServiceFactory {
    public static MealService getMealService() {
        Class c = null;
        try {
            c = Class.forName("com.jberry.services.meal.MealServiceImpl");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        MealService mealServiceInstance = null;
        try {
            mealServiceInstance = (MealService) c.newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return mealServiceInstance;
    }
}
