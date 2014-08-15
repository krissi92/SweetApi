package com.jberry.services.insulin;

import com.google.gson.Gson;
import com.jberry.dto.Food;
import com.jberry.dto.FoodTO;
import com.jberry.dto.Insulin;
import com.jberry.dto.User;
import com.jberry.services.food.FoodService;
import com.jberry.services.food.FoodServiceFactory;
import com.jberry.services.tools.ToolService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.omg.CORBA.NameValuePair;
import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class InsulinServiceImpl implements InsulinService {
    @Override
    public double calculateInsulin(long timeStamp, ArrayList<FoodTO> foodMap, double bloodSugar, boolean exercise) throws IOException{
        Insulin insulinInstance = new Insulin();
        ToolService tService = new ToolService();
        String url = "https://localhoast:3000/api/calculateInsulin";//TODO: Make a legit http url

        insulinInstance.setTimeStamp(timeStamp);
        insulinInstance.setTotalcarbs(sumObjectList(foodMap));
        insulinInstance.setBloodsugar(bloodSugar);
        insulinInstance.setExcersise(exercise);

        String ans = makeJson(insulinInstance);

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        post.setHeader("Authorization", "Basic " + tService.userEncoded());
        post.setHeader("Content-type", "application/json");
        post.setEntity(new StringEntity(ans));

        HttpResponse response = client.execute(post);
        response = client.execute(post);

        System.out.println("Response Code : "+ response.getStatusLine().getStatusCode());
        //getReader() for body of request
        return 55;
    }

    public double getCorrectRatio(String UserID) throws IOException{//TODO: Mjög líklega óðarfi.
        double ratio = 13.37;
        String url = "http://localhost:3000/api/insulin/getCorrectRatio/" + UserID;

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        HttpResponse response = client.execute(request);
        System.out.println(response.getEntity().getContent());

        return ratio;//TODO: return ratio.
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
