package com.jberry.services.insulin;

import com.google.gson.Gson;
import com.jberry.dto.FoodTO;
import com.jberry.dto.Insulin;
import com.jberry.dto.User;
import com.jberry.services.food.FoodService;
import com.jberry.services.food.FoodServiceFactory;
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
    public double calculateInsulin(long timeStamp, FoodTO[] foodMap, double bloodSugar, boolean exercise) throws IOException{
        Insulin insulinInstance = new Insulin();
        String url = "https://";//TODO: Make a legit http url

        insulinInstance.setRatio(getCorrectRatio("Admin")); //TODO: change Admin to a correct userID
        insulinInstance.setTimeStamp(timeStamp);
        insulinInstance.setTotalcarbs(sumObjectList(foodMap));
        insulinInstance.setBloodsugar(bloodSugar);
        insulinInstance.setExcersise(exercise);

        String ans = makeJson(insulinInstance);

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        post.setHeader("Authorization", "Basic " + userEncoded());
        post.setHeader("Content-type", "application/json");
        post.setEntity(new StringEntity(ans));

        HttpResponse response = client.execute(post);
        response = client.execute(post);

        System.out.println("Response Code : "+ response.getStatusLine().getStatusCode());

        //void fall(double ratio, double totalcarbs, double bloodsugar, boolean excersise);

        //svo er restinn gerð serverside.

        /*
        double unitsPerRatio = totalCarbs/ratio;
        double bloodSugarCorrection = (bloodSugar - checkInstance.getTargetBloodSugar())/checkInstance.getSensitivity();
        float bloodSugarLeftInBlood = (float) (1.0 - (checkInstance.getTimeSinceLast() * 0.25)) * checkInstance.getLastTimeUnits(); //active units

        double units = (unitsPerRatio + bloodSugarCorrection) - bloodSugarLeftInBlood;
        if (exercise){
            units = units * 0.5;
        }

        int insulin = (int) Math.round(units);

        checkInstance.setLastTimeUnits(insulin);

        return insulin;*/
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

    private String userEncoded(){
        User notandi = User.getTheUser();
        Base64 b64 = new Base64();
        String usr = notandi.getUserName() + ":" + notandi.getPassword();
        return b64.encodeAsString(usr.getBytes());
    }

    private double sumObjectList(FoodTO[] foods){
        FoodService foodServ = FoodServiceFactory.getFoodService();

        double totalCarbs = 0.0;
        for (int i = 0; i < foods.length - 1; i++) {
            String foodName = foods[i].getFoodName();
            double carbs = foodServ.getCarbsFromFood(foodName);

            double grams = foods[i].getGrams();
            carbs = (carbs/100) * grams;

            totalCarbs += carbs;
        }
        return totalCarbs;
    }
}
