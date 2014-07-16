package is.jberry.runners;

import com.jberry.dto.User;
import com.jberry.services.user.UserService;
import com.jberry.services.user.UserServiceFactory;

public class TestRunner {

	public static void main(String[] args) {
		UserService userService = UserServiceFactory.getUserService();

        System.out.print("Hello ma");

	}

}
