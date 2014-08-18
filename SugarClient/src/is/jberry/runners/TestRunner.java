package is.jberry.runners;

import com.jberry.dto.*;
import com.jberry.services.diabetic.DiabeticService;
import com.jberry.services.diabetic.DiabeticServiceFactory;
import com.jberry.services.insulin.InsulinService;
import com.jberry.services.insulin.InsulinServiceFactory;
import com.jberry.services.meal.MealService;
import com.jberry.services.meal.MealServiceFactory;
import com.jberry.services.profile.ProfileService;
import com.jberry.services.profile.ProfileServiceFactory;
import com.jberry.services.tools.ToolService;
import com.jberry.services.tools.ToolServiceFactory;
import com.jberry.services.user.UserService;
import com.jberry.services.user.UserServiceFactory;

import com.jberry.services.food.FoodService;
import com.jberry.services.food.FoodServiceFactory;
import org.apache.commons.codec.binary.Base64;

import java.util.*;

public class TestRunner {
	public static void main(String[] args) throws Exception {
        User user = User.getTheUser();
        UserService usr = UserServiceFactory.getUserService();
        if(usr.login("kalli@kalli.is","kalli")){
            System.out.println("YAY!!");
        }
        else{
            System.out.println("Boo");
        }

        MealService mealService = MealServiceFactory.getMealService();
        ArrayList<FoodTO> ing = new ArrayList<FoodTO>();
        ing.add(new FoodTO("banani", 200));
        ing.add(new FoodTO("epli", 100));
        ing.add(new FoodTO("ananas", 100));

        if (mealService.createMeal("moby",ing)){
            System.out.println("Create a Meal returns true");
            /*Meal mealMeal = mealService.getMealByMealId();
            System.out.println("nuserId: " + mealMeal.getUserId());
            System.out.println("ruserId: " + user.getId());
            System.out.println("mealMeal name: " + mealMeal.getMealName());
            System.out.println("mealMeal MId: " + mealMeal.getMealId());*/
        }

	}
}
