package is.jberry.runners;

import com.jberry.dto.User;
import com.jberry.services.user.UserService;
import com.jberry.services.user.UserServiceFactory;

public class TestRunner {
	public static void main(String[] args) throws Exception {
        UserService userService = UserServiceFactory.getUserService();
        User notandi = User.getTheUser();
        if (userService.login("kalli@kalli.com", "kalli")){
            System.out.println("YAY");
        }
	}
}
