package com.jberry.services.user;

import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.jberry.dto.User;

public class UserServiceImpl implements UserService {

	@Override
	public boolean login(String username, String password) throws Exception {
		// TODO Auto-generated method stub
        String Url = "http://localhost:3000";
        HttpClient client = new DefaultHttpClient();

        HttpGet request = new HttpGet(url);

        HttpResponse response = client.execute(request);
        System.out.println("\nSending 'GET' reguest to url:" + url);
        System.out.println("response code: " + response.getStatusLine().getStatusCode());
		return false;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
