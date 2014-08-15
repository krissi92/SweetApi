package is.jberry.runners;

import com.jberry.dto.FoodTO;
import com.jberry.dto.Insulin;
import com.jberry.dto.User;
import com.jberry.services.insulin.InsulinService;
import com.jberry.services.insulin.InsulinServiceFactory;
import com.jberry.services.user.UserService;
import com.jberry.services.user.UserServiceFactory;

import com.jberry.dto.Food;
import com.jberry.services.food.FoodService;
import com.jberry.services.food.FoodServiceFactory;
import org.apache.commons.codec.binary.Base64;

import java.util.*;

public class TestRunner {
	public static void main(String[] args) throws Exception {
        InsulinService ins = InsulinServiceFactory.getInsulinService();
        FoodService fsv = FoodServiceFactory.getFoodService();

        System.out.println(fsv.getFoodInformation("ba"));

        ArrayList<FoodTO> foodItems = new ArrayList<FoodTO>();
        foodItems.add(new FoodTO("Banana",100));
        foodItems.add(new FoodTO("apple", 120));
        foodItems.add(new FoodTO("mango", 222));

        ins.calculateInsulin(System.currentTimeMillis() / 1000, foodItems, 20, true);

        Base64 b64 = new Base64();
        String usr =  "jesus:jesus";
        System.out.println("encoding: " + b64.encodeAsString(usr.getBytes()));



	}
}
