package is.jberry.runners;

import com.jberry.dto.CalanderMeal;
import com.jberry.services.calendar.CalendarService;
import com.jberry.services.calendar.CalendarServiceFactory;

import java.util.List;

public class TestRunner {

	public static void main(String[] args) throws Exception {
        CalendarService calanderServer = CalendarServiceFactory.getCalanderService();
        List<CalanderMeal> list = calanderServer.getMealsByDay();

        for(int i = 0; i<list.size(); i++)
        {
            System.out.println("Name:" + list.get(i).mealName + ", time:" + list.get(i).timeOfMeal);
        }

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
