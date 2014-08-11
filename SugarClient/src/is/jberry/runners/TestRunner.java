package is.jberry.runners;


<<<<<<< HEAD
import com.jberry.services.user.UserService;
import com.jberry.services.user.UserServiceFactory;
=======
import com.jberry.dto.Food;
import com.jberry.services.food.FoodService;
import com.jberry.services.food.FoodServiceFactory;
>>>>>>> 05e25c3766e77b56f6aef6c8631ae1fe671cbb06
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class TestRunner {

	public static void main(String[] args) throws Exception {
<<<<<<< HEAD
        /*String url = "http://localhost:3000/ping";
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);

        HttpResponse response = client.execute(request);

        BufferedReader br = new BufferedReader(
                new InputStreamReader((response.getEntity().getContent())));

        StringBuilder builder = new StringBuilder();
        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            builder.append(output);
        }
        output = builder.toString();

        System.out.println("\nSending 'GET' request to url:" + url);
        System.out.println("response code: " + response.getStatusLine().getStatusCode());
        System.out.println("response: " + output);*/
        UserService User = UserServiceFactory.getUserService();
        User.register("oli222", "oli222","kaka222@kaka.is");

=======
        FoodService Feeder = FoodServiceFactory.getFoodService();

        Food[] itimm = Feeder.getFoodInformation("bacon");
        System.out.println(itimm[0].getNameEng());
        System.out.println(itimm[1].getNameEng());
        System.out.println(itimm[2].getNameEng());

        Food[] itimm2 = Feeder.getFoodInformation("banana");
        System.out.println(itimm2[0].getNameEng());

        System.out.println();
        double assmuncher = Feeder.getCarbsFromFood("ban");
        System.out.println("total carbs from bacon: " + assmuncher);

        System.out.println();
        ArrayList<String> codeBastion = Feeder.getFoodTitle("ba");
        System.out.println(codeBastion);

        System.out.println();
        Food[] itimm3 = Feeder.getFoodInformation("banana");
        System.out.println(itimm3[0].getNameEng());
        System.out.println(itimm3[0].getNameIce());
        System.out.println(itimm3[0].getFoodCategory());
        System.out.println(itimm3[0].getIron());
        System.out.println(itimm3[0].getAddedSugar());
        System.out.println(itimm3[0].getAlcohol());
        System.out.println(itimm3[0].getId());
>>>>>>> 05e25c3766e77b56f6aef6c8631ae1fe671cbb06
	}

}
