package is.jberry.runners;


import com.jberry.services.user.UserService;
import com.jberry.services.user.UserServiceFactory;
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

	}

}
