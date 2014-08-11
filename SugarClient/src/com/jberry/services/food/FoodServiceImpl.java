package com.jberry.services.food;

import com.google.gson.Gson;
import com.jberry.dto.Food;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FoodServiceImpl implements FoodService {
    @Override
    public ArrayList<String> getFoodTitle(String foodName){
        Food[] foodItems = new Food[0];
        ArrayList<String> results = new ArrayList<String>();
        try {
            foodItems = getFoodInformation(foodName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < foodItems.length; i++){
            results.add(foodItems[i].getNameEng());
        }
        return results;

    }

    @Override
    public double getCarbsFromFood(String foodName) {
        Food[] foodItems = new Food[0];
        try {
            foodItems = getFoodInformation(foodName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //ef það er fleyra en eitt item sem kemur til greina þá er skiluð summa af Carbs.
        if (foodItems.length > 1){
            double carbs = 0.0;
            for (int i = 0; i < foodItems.length; i++){
                carbs += foodItems[i].getTotalCarbohydrates();
            }
            return carbs;
        }
        else { return foodItems[0].getTotalCarbohydrates(); }
    }

    @Override
    public Food[] getFoodInformation(String foodName) throws IOException {
        String url = "http://localhost:3000/api/food/getByName/" + foodName;

        HttpClient client = new DefaultHttpClient();
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

        return jesus.fromJson(output,Food[].class);
    }
}
