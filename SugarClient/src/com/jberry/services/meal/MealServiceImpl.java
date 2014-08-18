package com.jberry.services.meal;

import com.google.gson.Gson;
import com.jberry.dto.Food;
import com.jberry.dto.FoodTO;
import com.jberry.dto.Meal;
import com.jberry.services.tools.ToolService;
import com.jberry.services.tools.ToolServiceFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MealServiceImpl implements MealService{
    @Override
    public boolean createMeal(String mealName, ArrayList<FoodTO> ingredients) throws IOException{
        ToolService toolService = ToolServiceFactory.getToolService();
        String url = "http://" + toolService.url() + ":3000/api/createMeal";

        Gson jesus = new Gson();
        String jsonJesus = jesus.toJson(ingredients);

        System.out.println(jsonJesus);

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        post.setHeader("Authorization", "Basic " + toolService.userEncoded());
        post.setHeader("Content-type", "application/json");
        post.setHeader("mealName", mealName);
        post.setEntity(new StringEntity(jsonJesus));

        HttpResponse response = client.execute(post);
        if (response.getStatusLine().getStatusCode() == 302){
            return true;
        }
        return false;
    }
    @Override
    public Meal getMealById(String mealId) throws IOException {
        ToolService toolService = ToolServiceFactory.getToolService();
        String url = "http://" + toolService.url() + ":3000/api/food/getMealById";

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        request.setHeader("Authorization", "Basic " + toolService.userEncoded());
        request.setHeader("mealId", mealId);

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
        return jesus.fromJson(output ,Meal.class);
    }
    public ArrayList<Meal> getMealsByUserId() throws IOException {
        ToolService toolService = ToolServiceFactory.getToolService();
        String url = "http://" + toolService.url() + ":3000/api/food/getMealByUserId";

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        request.setHeader("Authorization", "Basic " + toolService.userEncoded());

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
        Meal[] meals = jesus.fromJson(output ,Meal[].class);

        return new ArrayList<Meal>(Arrays.asList(meals));
    }
    public boolean editMeal(String mealId){
        return true;
    }

    //public getNutritionFromMeal();
}
