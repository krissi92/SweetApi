package is.jberry.runners;


import com.jberry.dto.Food;
import com.jberry.services.food.FoodService;
import com.jberry.services.food.FoodServiceFactory;
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
        FoodService Feeder = FoodServiceFactory.getFoodService();

        Food[] itimm = Feeder.getFoodInformation("bacon");

        System.out.println(itimm[0].getNameEng());
        System.out.println(itimm[1].getNameEng());
        System.out.println(itimm[2].getNameEng());

        Food[] itimm2 = Feeder.getFoodInformation("banana");

        System.out.println(itimm2[0].getNameEng());

        System.out.println();
        double assmuncher = Feeder.getCarbsFromFood("bacon");
        System.out.println(assmuncher);

        System.out.println();
        ArrayList<String> codeBastion = Feeder.getFoodTitle("ba");
        System.out.println(codeBastion);


        /*
        String url = "http://localhost:3000/ping";
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
        System.out.println("response: " + output);
        */
	}

}
