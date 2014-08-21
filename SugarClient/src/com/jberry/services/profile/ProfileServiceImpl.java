package com.jberry.services.profile;

import com.google.gson.Gson;
import com.jberry.dto.Profile;
import com.jberry.services.tools.ToolService;
import com.jberry.services.tools.ToolServiceFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProfileServiceImpl implements ProfileService {

    @Override
    public Profile getUserProfile(String userId) throws IOException {
        ToolService toolService = ToolServiceFactory.getToolService();
        String url = "http://" + toolService.url() + ":3000/api/profile";

        HttpClient httpClient = new DefaultHttpClient();
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
        String url = "http://" + toolService.url() + ":3000/api/profile/update";

        Gson jesus = new Gson();
        String jsonObject = jesus.toJson(user);

        HttpClient httpClient = new DefaultHttpClient();
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
