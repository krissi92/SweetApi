package is.jberry.runners;

import com.jberry.dto.CalanderMeal;
import com.jberry.services.calendar.CalendarService;
import com.jberry.services.calendar.CalendarServiceFactory;
import com.jberry.services.checkin.CheckInService;
import com.jberry.services.checkin.CheckInServiceFactory;

import java.util.*;

public class TestRunner {

	public static void main(String[] args) throws Exception {
        CheckInService checker = CheckInServiceFactory.getCheckInService();

        Map<String, Integer> testMap = new HashMap<String, Integer>();
        testMap.put("Ananas", 120);
        testMap.put("Banani", 120);
        testMap.put("Kiwi", 120);
        testMap.put("Banani", 130);


        int vampire = checker.calculateInsulin(5.5, testMap, 5.5, true);
        System.out.print("you need this amount of Blood " + vampire);
	}

}
