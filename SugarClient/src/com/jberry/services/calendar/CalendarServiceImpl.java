package com.jberry.services.calendar;

import com.google.gson.Gson;
import com.jberry.dto.CalanderMeal;
import com.jberry.services.tools.ToolService;
import com.jberry.services.tools.ToolServiceFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

import java.util.*;

public class CalendarServiceImpl implements CalendarService {
    @Override
    public boolean saveMealToCalander(String mealName, long timeStamp) throws IOException {
        ToolService toolService = ToolServiceFactory.getToolService();
        String url = "http://" + toolService.url() + ":3000/api/saveMealToCalander";

        CalanderMeal calanderMeal = new CalanderMeal(mealName,timeStamp);

        Gson jesus = new Gson();
        String output = jesus.toJson(calanderMeal,CalanderMeal.class);

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        post.setHeader("Authorization", "Basic " + toolService.userEncoded());
        post.setHeader("Content-type", "application/json");
        post.setEntity(new StringEntity(output));

        HttpResponse response = client.execute(post);
        if (response.getStatusLine().getStatusCode() == 302){
            return true;
        }
        return false;
    }
    @Override
    public ArrayList<CalanderMeal> getMealsByDay(long timeStamp) throws IOException{
        ToolService toolService = ToolServiceFactory.getToolService();
        String url = "http://" + toolService.url() + ":3000/api/getMealsByDay";

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        request.setHeader("Authorization", "Basic " + toolService.userEncoded());
        request.setHeader("timeStamp", String.valueOf(timeStamp));

        HttpResponse response = client.execute(request);
        BufferedReader br = new BufferedReader(
                new InputStreamReader((response.getEntity().getContent())));

        StringBuilder builder = new StringBuilder();
        String output;
        while ((output = br.readLine()) != null) {
            builder.append(output);
        }
        output = builder.toString();

        Gson jesus = new Gson();
        CalanderMeal[] cal = jesus.fromJson(output ,CalanderMeal[].class);

        return new ArrayList<CalanderMeal>(Arrays.asList(cal));
    }
    @Override
    public boolean deleteFromCalendar(long timeOfMeal) throws IOException {
        ToolService toolService = ToolServiceFactory.getToolService();
        String url = "http://" + toolService.url() + ":3000/api/deleteFromCalendar";

        HttpClient client = HttpClientBuilder.create().build();
        HttpDelete request = new HttpDelete(url);
        request.setHeader("Authorization", "Basic " + toolService.userEncoded());
        request.setHeader("timeOfMeal", String.valueOf(timeOfMeal));

        HttpResponse response = client.execute(request);

        if (response.getStatusLine().getStatusCode() == 200){
            return true;
        }
        return false;
    }
}
