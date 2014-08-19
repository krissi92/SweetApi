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

import javax.tools.Tool;
import java.util.*;

public class TestRunner {
	public static void main(String[] args) throws Exception {
        User user = User.getTheUser();
        ToolService tool = ToolServiceFactory.getToolService();
        UserService usr = UserServiceFactory.getUserService();
        if(usr.login("kalli@kalli.is","kalli")){
            System.out.println("Logged in!!");
            System.out.println("Basic " + tool.userEncoded());
        }
        else{
            System.out.println("Not logged in");
        }

        MealService mealService = MealServiceFactory.getMealService();
        ArrayList<FoodTO> ing = new ArrayList<FoodTO>();
        ing.add(new FoodTO("Potato chips, fatty", 10));
        ing.add(new FoodTO("Lobster, raw", 200));
        ing.add(new FoodTO("Bread, Italian, average", 50));

        if (mealService.deleteMeal("Clean Burgers")){//mealService.createMeal("Clean Burgers",ing)){
            System.out.println("Create a Meal returns true");
            /*Meal mealMeal = mealService.getMealByName("dirty burgers");
            //System.out.println("nuserId: " + mealMeal.getUserId("53f36bc1a680db64101ec2ee"));
            ArrayList<Meal> krissi = mealService.getMealsByUserId();
            Meal meal = mealService.getMealByName("dirty burgers");
            System.out.println(krissi.get(0).getMealName());
            System.out.println(krissi.get(1).getMealName());*/
        }

	}
}
