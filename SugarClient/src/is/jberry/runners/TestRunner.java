package is.jberry.runners;

import com.jberry.dto.FoodTO;
import com.jberry.dto.Insulin;
import com.jberry.services.insulin.InsulinService;
import com.jberry.services.insulin.InsulinServiceFactory;
import com.jberry.services.user.UserService;
import com.jberry.services.user.UserServiceFactory;

import com.jberry.dto.Food;
import com.jberry.services.food.FoodService;
import com.jberry.services.food.FoodServiceFactory;

import java.util.*;

public class TestRunner {
	public static void main(String[] args) throws Exception {
        InsulinService ins = InsulinServiceFactory.getInsulinService();
        FoodService fsv = FoodServiceFactory.getFoodService();

        System.out.println(fsv.getCarbsFromFood("ba"));

        FoodTO[] foodItems = new FoodTO[2];

        foodItems[0] = new FoodTO();
        foodItems[0].setFoodName("banana");
        foodItems[0].setGrams(22);
        foodItems[1] = new FoodTO();
        foodItems[1].setFoodName("epli");
        foodItems[1].setGrams(11);


        ins.calculateInsulin(System.currentTimeMillis()/1000,foodItems,20,true);

	}
}
