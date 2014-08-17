package com.jberry.services.user;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.util.List;


import com.jberry.dto.User;

import com.jberry.services.tools.ToolService;
import com.jberry.services.tools.ToolServiceFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
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
        System.out.println("\nSending 'GET' request to url:" + Url);
        System.out.println("response code: " + response.getStatusLine().getStatusCode());

        if(response.getStatusLine().getStatusCode() != 302){
            return false;
        }
        if (!initUser(email, password)){
            return false;
        }
        return true;
	}

    private boolean initUser(String email, String password){
        User user = User.getTheUser();
        user.setEmail(email);
        user.setPassword(password);

        return true;
    }

    //registers the user and returns true if successful.
    @Override
    public boolean register(String username, String password, String email) throws IOException {//TODO:Depricated?

        String Url = "http://10.0.2.2:3000/sweet/register";
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost httppost = new HttpPost(Url);

        List<NameValuePair> params = new LinkedList<NameValuePair>();
        params.add(new BasicNameValuePair("name", username));
        params.add(new BasicNameValuePair("email", email));
        params.add(new BasicNameValuePair("password", password));

        httppost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));

        HttpResponse response = client.execute(httppost);
        if(response.getStatusLine().getStatusCode() != 302)
        {
            return false;
        }
        return true;
    }
}
