package com.jberry.services.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import com.google.gson.Gson;
import com.jberry.dto.User;
import com.jberry.services.tools.ToolService;
import com.jberry.services.tools.ToolServiceFactory;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class UserServiceImpl implements UserService {
	@Override
	public boolean login(String email, String password) throws IOException{
        ToolService toolService = ToolServiceFactory.getToolService();
        String Url = "http://" + toolService.url() + ":3000/api/login";

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(Url);

        List<NameValuePair> params = new LinkedList<NameValuePair>();
        params.add(new BasicNameValuePair("email", email));
        params.add(new BasicNameValuePair("password", password));

        request.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
        HttpResponse response = client.execute(request);

        if(response.getStatusLine().getStatusCode() != 302){
            return false;
        }
        User notandi = User.getTheUser();
        notandi.setEmail(email);
        notandi.setPassword(password);
        if (!initUser(email, password)){
            return false;
        }
        return true;
	}

    private boolean initUser(String email, String password) throws IOException {
        User user = User.getTheUser();
        //user.setEmail(email);
        //user.setPassword(password);
        ToolService toolService = ToolServiceFactory.getToolService();
        String url = "http://" + toolService.url() + ":3000/api/userinfo";

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        request.setHeader("Authorization", "Basic " + toolService.userEncoded());

        HttpResponse response = client.execute(request);
        if (response.getStatusLine().getStatusCode() != 200){ return false; }

        BufferedReader br = new BufferedReader(
                new InputStreamReader((response.getEntity().getContent())));

        StringBuilder builder = new StringBuilder();
        String output;
        while ((output = br.readLine()) != null) {
            builder.append(output);
        }
        output = builder.toString();

        Gson jesus = new Gson();
        User usr = jesus.fromJson(output ,User.class);

        user.setId(usr.getId());
        user.setUserName(usr.getUserName());

        return true;
    }
}
