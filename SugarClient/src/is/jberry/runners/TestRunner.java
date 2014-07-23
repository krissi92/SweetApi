package is.jberry.runners;

import com.jberry.dto.CalanderMeal;
import com.jberry.services.calendar.CalendarService;
import com.jberry.services.calendar.CalendarServiceFactory;
import com.jberry.services.checkin.CheckInService;
import com.jberry.services.checkin.CheckInServiceFactory;

import java.util.List;

public class TestRunner {

	public static void main(String[] args) throws Exception {
        CheckInService checker = CheckInServiceFactory.getCheckInService();
        int vampire = checker.calculateInsulin(5.5, "Banana", 200, 5.5, true);
        System.out.print("you need this amount of Blood " + vampire);
	}

}
