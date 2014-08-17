package com.jberry.services.profile;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jberry.dto.Profile;
import com.jberry.services.tools.ToolService;
import com.jberry.services.tools.ToolServiceFactory;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ProfileServiceImpl implements ProfileService {

    @Override
    public Profile getUserProfile(String userId) throws IOException {
        ToolService toolService = ToolServiceFactory.getToolService();
        String url = "http://localhost:3000/api/profile";

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        request.setHeader("Authorization", "Basic " + toolService.userEncoded());

        HttpResponse response = httpClient.execute(request);

        BufferedReader br = new BufferedReader(
                new InputStreamReader((response.getEntity().getContent())));

        StringBuilder builder = new StringBuilder();
        String output;
        while ((output = br.readLine()) != null) {
            builder.append(output);
        }
        output = builder.toString();

        Gson jesus = new Gson();

        return jesus.fromJson(output, Profile.class);
    }

    @Override
    public boolean postUpdatedProfile(Profile user) throws IOException {
        ToolService toolService = ToolServiceFactory.getToolService();
        String url = "http://localhost:3000/api/profile/update";

        Gson jesus = new Gson();
        String jsonObject = jesus.toJson(user);

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPut putReq = new HttpPut(url);
        putReq.setHeader("Authorization", "Basic " + toolService.userEncoded());
        putReq.setHeader("Content-type", "application/json");
        putReq.setEntity(new StringEntity(jsonObject));

        HttpResponse response = httpClient.execute(putReq);

        if (response.getStatusLine().getStatusCode() == 200){
            return true;
        }
        return false;
    }
}
