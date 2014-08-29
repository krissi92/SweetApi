package is.jberry.runners;

import com.jberry.dto.CalanderMeal;
import com.jberry.dto.FoodTO;
import com.jberry.dto.User;
import com.jberry.services.calendar.CalendarService;
import com.jberry.services.calendar.CalendarServiceFactory;
import com.jberry.services.meal.MealService;
import com.jberry.services.meal.MealServiceFactory;
import com.jberry.services.user.UserService;
import com.jberry.services.user.UserServiceFactory;

import java.util.ArrayList;

public class TestRunner {
	public static void main(String[] args) throws Exception {
        UserService userService = UserServiceFactory.getUserService();
        User notandi = User.getTheUser();
        if (userService.login("yolo@swag.com", "yoloswag")){
            System.out.println("YAY");
        }

       // CalendarService cal = CalendarServiceFactory.getCalanderService();
        //ArrayList<CalanderMeal> Listcal = new ArrayList<CalanderMeal>();
        //Listcal = cal.getMealsByDay(1409356800);*/

        //Listcal = cal.getMealsByDay(1409261809);


        //System.out.println("size: " + Listcal.size());
        /*MealService maltid = MealServiceFactory.getMealService();
        ArrayList<FoodTO> matur = new ArrayList<FoodTO>();
        FoodTO banani = new FoodTO("banana", 20);
        matur.add(banani);
        boolean test = maltid.createMeal("BANANASALAT", matur);*/
        /*System.out.println("Length: " + Listcal.size());
        System.out.println("Else: " + Listcal);*/


        /*if(test == true)
        {
            System.out.println("Veij!");
        }
        if(test2 == true)
        {
            System.out.println("Veij!!!!");
        }*/

    }
}
