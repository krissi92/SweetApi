package com.jberry.services.profile;

import com.google.gson.JsonObject;
import com.jberry.dto.Profile;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krissi on 5.8.2014.
 */
public class ProfileServiceImpl implements ProfileService {

    @Override
    public Profile getUserProfile(String userId) {

        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet("http://localhost:3000/api/diabeticProfile");
        httpget.addHeader("user._iD", userId);
        HttpResponse response;
        try {

            response = httpClient.execute(httpget);
            System.out.println("status message: " + response.getStatusLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Profile getProfile = new Profile();
        

        return null;
    }

    @Override
    public Profile postUpdatedProfile(Profile user) throws IOException {

        JsonObject profile = new JsonObject();
        profile.addProperty("weight", user.getWeight());
        profile.addProperty("height", user.getHeight());
        profile.addProperty("sex", user.getSex());
        profile.addProperty("birthday", user.getBirthDay());

        StringEntity params = null;
        try {

            HttpClient httpClient = new DefaultHttpClient();
            HttpPut putReq = new HttpPut("http://localhost:3000/api/profile/update");
            params = new StringEntity(profile.toString());
            putReq.setEntity(params);
            HttpResponse response = httpClient.execute(putReq);
            System.out.println("StatusCode: " + response.getStatusLine());

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
