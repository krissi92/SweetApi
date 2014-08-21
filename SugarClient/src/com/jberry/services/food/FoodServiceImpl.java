package com.jberry.services.food;

import com.google.gson.Gson;
import com.jberry.dto.Food;
import com.jberry.services.tools.ToolService;
import com.jberry.services.tools.ToolServiceFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class FoodServiceImpl implements FoodService {
    @Override
    public ArrayList<String> getFoodTitle(String foodName){
        ArrayList<Food> foodItems = new ArrayList<Food>();
        ArrayList<String> results = new ArrayList<String>();
        try {
            foodItems = getFoodInformation(foodName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Food food : foodItems){
            results.add(food.getNameEng());
        }
        return results;
    }

    @Override
    public double getTotalCarbsFromFood(String foodName) {
        ArrayList<Food> foodItems = new ArrayList<Food>();
        try {
            foodItems = getFoodInformation(foodName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        double carbs = 0.0;
        for (Food food : foodItems){
            carbs += food.getTotalCarbohydrates();
        }
        return carbs;
    }

    @Override
    public double getTotalFatFromFood(String foodName) {
        ArrayList<Food> foodItems = new ArrayList<Food>();
        try {
            foodItems = getFoodInformation(foodName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        double fat = 0.0;
        for (Food food : foodItems){
            fat += food.getFat();
        }
        return fat;
    }

    @Override
    public double getTotalProteinsFromFood(String foodName) {
        ArrayList<Food> foodItems = new ArrayList<Food>();
        try {
            foodItems = getFoodInformation(foodName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        double proteins = 0.0;
        for (Food food : foodItems){
            proteins += food.getProteins();
        }
        return proteins;
    }

    @Override
    public double getTotalSugarFromFood(String foodName) {
        ArrayList<Food> foodItems = new ArrayList<Food>();
        try {
            foodItems = getFoodInformation(foodName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        double sugar = 0.0;
        for (Food food : foodItems){
            sugar += food.getSugars();
        }
        return sugar;
    }

    @Override
    public double getTotalCholesterolFromFood(String foodName) {
        ArrayList<Food> foodItems = new ArrayList<Food>();
        try {
            foodItems = getFoodInformation(foodName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        double cholesterol = 0.0;
        for (Food food : foodItems){
            cholesterol += food.getCholesterol();
        }
        return cholesterol;
    }

    @Override
    public double getTotalFiberFromFood(String foodName) {
        ArrayList<Food> foodItems = new ArrayList<Food>();
        try {
            foodItems = getFoodInformation(foodName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        double fiber = 0.0;
        for (Food food : foodItems){
            fiber  += food.getFiber();
        }
        return fiber ;
    }

    @Override
    public ArrayList<Food> getFoodInformation(String foodName) throws IOException {
        ToolService toolService = ToolServiceFactory.getToolService();
        foodName = foodName.replace(" ","%20"); //because fuck jBerry
        String url = "http://" + toolService.url() + ":3000/api/food/getByName/" + foodName;

        HttpClient client = new DefaultHttpClient();
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
        Food[] fud = jesus.fromJson(output ,Food[].class);

        return new ArrayList<Food>(Arrays.asList(fud));
    }
}
