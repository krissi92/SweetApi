package com.jberry.services.food;

import com.google.gson.Gson;
import com.jberry.dto.Food;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
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
    public double getCarbsFromFood(String foodName) {
        ArrayList<Food> foodItems = new ArrayList<Food>();
        try {
            foodItems = getFoodInformation(foodName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //ef það er fleyra en eitt item sem kemur til greina þá er skiluð summa af Carbs.
        double carbs = 0.0;
        for (Food food : foodItems){
            carbs += food.getTotalCarbohydrates();
        }
        return carbs;
    }

    @Override
    public ArrayList<Food> getFoodInformation(String foodName) throws IOException {
        String url = "http://localhost:3000/api/food/getByName/" + foodName;

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

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
        return new ArrayList<Food>(Arrays.asList(jesus.fromJson(output,Food[].class)));
    }
}
