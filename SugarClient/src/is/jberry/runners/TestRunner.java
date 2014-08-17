package is.jberry.runners;

import com.jberry.dto.*;
import com.jberry.services.diabetic.DiabeticService;
import com.jberry.services.diabetic.DiabeticServiceFactory;
import com.jberry.services.insulin.InsulinService;
import com.jberry.services.insulin.InsulinServiceFactory;
import com.jberry.services.profile.ProfileService;
import com.jberry.services.profile.ProfileServiceFactory;
import com.jberry.services.tools.ToolService;
import com.jberry.services.tools.ToolServiceFactory;
import com.jberry.services.user.UserService;
import com.jberry.services.user.UserServiceFactory;

import com.jberry.services.food.FoodService;
import com.jberry.services.food.FoodServiceFactory;
import org.apache.commons.codec.binary.Base64;

import java.util.*;

public class TestRunner {
	public static void main(String[] args) throws Exception {
        User daUser = User.getTheUser();
        daUser.setId("53f0d8834374ebf140097a89");
        daUser.setUserName("kalli");
        daUser.setPassword("kalli");
        daUser.setEmail("kalli@kalli.is");

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

        Profile profile = new Profile();
        ProfileService profileService = ProfileServiceFactory.getProfileService();
        profile = profileService.getUserProfile(daUser.getId());
        System.out.println(profile.getBirthDay());

        profile.setSex("KK");

        profileService.postUpdatedProfile(profile);

        DiabeticService diabeticService = DiabeticServiceFactory.getDiabeticService();
        Diabetic D = diabeticService.getDiabeticInfo("53f0d8834374ebf140097a89");
        D.setNoonRatio(50.5);
        diabeticService.postDiabeticInfo(D);

        Diabetic B = diabeticService.getDiabeticInfo("53f0d8834374ebf140097a89");
        System.out.println("Shanghigh Noon " + B.getNoonRatio());

        Base64 b64 = new Base64();
        String notandi =  "jesus:jesus";
        System.out.println("encoding: " + b64.encodeAsString(notandi.getBytes()));

	}
}
