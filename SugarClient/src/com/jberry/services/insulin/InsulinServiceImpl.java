package com.jberry.services.insulin;

import com.google.gson.Gson;
import com.jberry.dto.Food;
import com.jberry.dto.FoodTO;
import com.jberry.dto.Insulin;
import com.jberry.dto.User;
import com.jberry.services.food.FoodService;
import com.jberry.services.food.FoodServiceFactory;
import com.jberry.services.tools.ToolService;
import com.jberry.services.tools.ToolServiceFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.omg.CORBA.NameValuePair;
import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Encoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class InsulinServiceImpl implements InsulinService {
    @Override
    public double calculateInsulin(long timeStamp, ArrayList<FoodTO> foodMap, double bloodSugar, boolean exercise) throws IOException{
        Insulin insulinInstance = new Insulin();
        ToolService tService = new ToolService();
        String url = "http://" + tService.url() + ":3000/api/calculateInsuline";//TODO: Make a legit http url

        insulinInstance.setTimeStamp(timeStamp);
        insulinInstance.setTotalCarbs(sumObjectList(foodMap));//TODO:Mebbeh round
        insulinInstance.setBloodSugar(bloodSugar);
        insulinInstance.setExcersise(exercise);

        String ans = makeJson(insulinInstance);

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        post.setHeader("Authorization", "Basic " + tService.userEncoded());
        post.setHeader("Content-type", "application/json");
        post.setEntity(new StringEntity(ans));

        System.out.println("ans: " + ans);

        HttpResponse response = client.execute(post);

        BufferedReader br = new BufferedReader(
                new InputStreamReader((response.getEntity().getContent())));

        StringBuilder builder = new StringBuilder();
        String output;
        while ((output = br.readLine()) != null) {
            builder.append(output);
        }
        output = builder.toString();
        return Double.parseDouble(output);
    }

    private String makeJson(Insulin ins){
        Gson jesus = new Gson();
        return jesus.toJson(ins);
    }

    private double sumObjectList(ArrayList<FoodTO> foodItems){
        FoodService foodServ = FoodServiceFactory.getFoodService();

        double totalCarbs = 0.0;
        for (FoodTO foods : foodItems){
            double carbs = foodServ.getCarbsFromFood(foods.getFoodName());
            double grams = foods.getGrams();
            carbs = (carbs/100) * grams;
            totalCarbs += carbs;
        }
        return totalCarbs;
    }
}
