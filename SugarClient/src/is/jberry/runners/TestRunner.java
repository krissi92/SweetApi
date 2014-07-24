package is.jberry.runners;

import com.jberry.dto.CalanderMeal;
import com.jberry.dto.Food;
import com.jberry.dto.Meal;
import com.jberry.services.calendar.CalendarService;
import com.jberry.services.calendar.CalendarServiceFactory;
import com.jberry.services.food.FoodService;
import com.jberry.services.food.FoodServiceFactory;
import com.jberry.services.meal.MealService;
import com.jberry.services.meal.MealServiceFactory;

import java.util.ArrayList;
import java.util.Map;
import java.util.Hashtable;
import java.util.List;

public class TestRunner {

	public static void main(String[] args) throws Exception {

        CalendarService Cal = CalendarServiceFactory.getCalanderService();
        List<CalanderMeal> bla = Cal.getMealsByDay((long)1449446400);

        for(int i = 0; i < bla.size(); i++){
            System.out.println("Name:" + bla.get(i).mealName + " Time: " + bla.get(i).timeOfMeal);
        }

        /*FoodService FoodS = FoodServiceFactory.getFoodService();
        Food Banan = FoodS.getFoodInformation();

        System.out.println("Name: " + Banan.Nafn);
        System.out.println("EH: " + Banan.Fæðuflokkur);
*/
        /*MealService Meal123 = MealServiceFactory.getMealService();
        Meal Banana = Meal123.getMealByName();
        System.out.println("Nafn: " + Banana.MealName);
        for(Map.Entry<String, Integer> entry : Banana.Ingredients.entrySet()) {
            System.out.println("Ingrediant: " + entry.getKey() + "- Magn: " + entry.getValue());
        }*/
		/*UserService userService = UserServiceFactory.getUserService();
        boolean test1 = userService.login("admin", "admin");
        if(test1 == true) {
            System.out.print("success brah");
        }
        else {
            System.out.print("failed brah");
        }*/
	}

}
