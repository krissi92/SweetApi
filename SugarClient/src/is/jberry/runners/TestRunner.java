package is.jberry.runners;

import com.jberry.dto.FoodTO;
import com.jberry.dto.Insulin;
import com.jberry.dto.User;
import com.jberry.services.insulin.InsulinService;
import com.jberry.services.insulin.InsulinServiceFactory;
import com.jberry.services.tools.ToolService;
import com.jberry.services.tools.ToolServiceFactory;
import com.jberry.services.user.UserService;
import com.jberry.services.user.UserServiceFactory;

import com.jberry.dto.Food;
import com.jberry.services.food.FoodService;
import com.jberry.services.food.FoodServiceFactory;
import org.apache.commons.codec.binary.Base64;

import java.util.*;

public class TestRunner {
	public static void main(String[] args) throws Exception {
        User daUser = User.getTheUser();
        daUser.setId("53f0bc0a26d9161b2be653c3");
        daUser.setUserName("ragnar");
        daUser.setPassword("ragnar");
        daUser.setEmail("ragnar@ragnar.is");

        ToolService toolService = ToolServiceFactory.getToolService();
        System.out.println(toolService.testSingleTon());

        UserService usr = UserServiceFactory.getUserService();

        //usr.login(daUser.getUserName(), daUser.getPassword());

        InsulinService ins = InsulinServiceFactory.getInsulinService();
        FoodService fsv = FoodServiceFactory.getFoodService();

        //System.out.println(fsv.getFoodInformation("banana"));

        ArrayList<FoodTO> foodItems = new ArrayList<FoodTO>();
        foodItems.add(new FoodTO("Banana",100));
        foodItems.add(new FoodTO("apple", 120));
        foodItems.add(new FoodTO("mango", 222));

        System.out.println("Insulin: " + ins.calculateInsulin(System.currentTimeMillis() / 1000, foodItems, 20, true));

        Base64 b64 = new Base64();
        String notandi =  "jesus:jesus";
        System.out.println("encoding: " + b64.encodeAsString(notandi.getBytes()));

	}
}
