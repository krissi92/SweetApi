package com.jberry.services.meal;

import com.google.gson.Gson;
import com.jberry.dto.FoodTO;
import com.jberry.dto.Meal;
import com.jberry.services.food.FoodService;
import com.jberry.services.food.FoodServiceFactory;
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
import java.util.*;

public class MealServiceImpl implements MealService{
    @Override
    public boolean createMeal(String mealName, ArrayList<FoodTO> ingredients) throws IOException{
        ToolService toolService = ToolServiceFactory.getToolService();
        String url = "http://" + toolService.url() + ":3000/api/createMeal";

        FoodService foodService = FoodServiceFactory.getFoodService();

        double totalCarbs = 0;
        double totalProtein = 0;
        double totalSugar = 0;
        double totalCholesterol = 0;
        double totalFiber = 0;

        for (FoodTO mealItems : ingredients){
            totalCarbs += foodService.getTotalCarbsFromFood(mealItems.getFoodName());
            totalProtein += foodService.getTotalProteinsFromFood(mealItems.getFoodName());
            totalSugar += foodService.getTotalSugarFromFood(mealItems.getFoodName());
            totalCholesterol += foodService.getTotalCholesterolFromFood(mealItems.getFoodName());
            totalFiber += foodService.getTotalFiberFromFood(mealItems.getFoodName());
        }

        Gson jesus = new Gson();
        String jsonJesus = jesus.toJson(ingredients);

        String krissiJesus = "{ \"mealName\":\"" + mealName + "\", " +
                "\"ingredients\":" + jsonJesus + "," +
                "\"totalCarbs\":\"" + totalCarbs + "\"," +
                "\"totalProtein\":\"" + totalProtein + "\"," +
                "\"totalSugar\":\"" + totalSugar + "\"," +
                "\"totalCholesterol\":\"" + totalCholesterol + "\", " +
                "\"totalFiber\":\"" + totalFiber + "\" }";
        System.out.println("Json búið");
        System.out.println(krissiJesus);

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        post.setHeader("Authorization", "Basic " + toolService.userEncoded());
        post.setHeader("Content-type", "application/json");
        post.setEntity(new StringEntity(krissiJesus));

        HttpResponse response = client.execute(post);
        if (response.getStatusLine().getStatusCode() == 302){
            return true;
        }
        return false;
    }
    @Override
    public Meal getMealByName(String mealName) throws IOException {
        ToolService toolService = ToolServiceFactory.getToolService();
        String url = "http://" + toolService.url() + ":3000/api/getMealByName";

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        request.setHeader("Authorization", "Basic " + toolService.userEncoded());
        request.setHeader("mealName", mealName);

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
        Meal meal = jesus.fromJson(output ,Meal.class);
        meal.setIngredients(getIngredients(mealName));
        return meal;
    }
    private ArrayList<FoodTO> getIngredients(String mealName) throws IOException {
        ToolService toolService = ToolServiceFactory.getToolService();
        String url = "http://" + toolService.url() + ":3000/api/getMealByName/ingredients";

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        request.setHeader("Authorization", "Basic " + toolService.userEncoded());
        request.setHeader("mealName", mealName);

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
        //return jesus.fromJson(output ,Meal.class);
        FoodTO[] meals = jesus.fromJson(output ,FoodTO[].class);

        return new ArrayList<FoodTO>(Arrays.asList(meals));
    }

    public ArrayList<Meal> getMealsByUserId() throws IOException {
        ToolService toolService = ToolServiceFactory.getToolService();
        String url = "http://" + toolService.url() + ":3000/api/getMealsByUserId";

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
    @Override
    public boolean deleteMeal(String mealName) throws IOException {
        ToolService toolService = ToolServiceFactory.getToolService();
        String url = "http://" + toolService.url() + ":3000/api/deleteMeal";

        HttpClient client = HttpClientBuilder.create().build();
        HttpDelete request = new HttpDelete(url);
        request.setHeader("Authorization", "Basic " + toolService.userEncoded());
        request.setHeader("mealName", mealName);

        HttpResponse response = client.execute(request);

        if (response.getStatusLine().getStatusCode() == 200){
            return true;
        }
        return false;
    }
    @Override
    public boolean editMeal(String mealName, ArrayList<FoodTO> newIngredients) throws IOException{
        if (createMeal(mealName,newIngredients)){
            if (deleteMeal(mealName)){
                return true;
            }
        }
        return false;
    }
}
