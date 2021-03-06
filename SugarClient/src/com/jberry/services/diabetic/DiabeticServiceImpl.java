package com.jberry.services.diabetic;

import com.google.gson.Gson;
import com.jberry.dto.Diabetic;
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

public class DiabeticServiceImpl implements DiabeticService{
    @Override
    public boolean postDiabeticInfo(Diabetic DiabeticUsr) throws IOException{
        ToolService toolService = ToolServiceFactory.getToolService();
        String url = "http://" + toolService.url() + ":3000/api/updateDiabeticInfo";

        Gson jesus = new Gson();
        String ans = jesus.toJson(DiabeticUsr);

        HttpClient client = new DefaultHttpClient();
        HttpPut post = new HttpPut(url);
        post.setHeader("Authorization", "Basic " + toolService.userEncoded());
        post.setHeader("Content-type", "application/json");
        post.setEntity(new StringEntity(ans));

        HttpResponse response = client.execute(post);
        if (response.getStatusLine().getStatusCode() == 200){
            return true;
        }
        return false;
    }

    @Override
    public Diabetic getDiabeticInfo(String userId) throws IOException {
        ToolService toolService = ToolServiceFactory.getToolService();
        String url = "http://" + toolService.url() + ":3000/api/getDiabeticInfo";

        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);
        request.setHeader("Authorization", "Basic " + toolService.userEncoded());

        HttpResponse response = client.execute(request);

        BufferedReader br = null;
        br = new BufferedReader(
            new InputStreamReader((response.getEntity().getContent())));

        StringBuilder builder = new StringBuilder();
        String output;
        while ((output = br.readLine()) != null) {
            builder.append(output);
        }
        output = builder.toString();
        br.close();
        Gson jesus = new Gson();
        return jesus.fromJson(output, Diabetic.class);
    }
    public boolean finishCheckIn(Diabetic DiabeticUsr) throws IOException{
        ToolService toolService = ToolServiceFactory.getToolService();
        String url = "http://" + toolService.url() + ":3000/api/setCheckinInfo";

        Gson jesus = new Gson();
        String ans = jesus.toJson(DiabeticUsr);

        HttpClient client = new DefaultHttpClient();
        HttpPut put = new HttpPut(url);
        put.setHeader("Authorization", "Basic " + toolService.userEncoded());
        put.setHeader("Content-type", "application/json");
        put.setEntity(new StringEntity(ans));

        HttpResponse response = client.execute(put);
        if (response.getStatusLine().getStatusCode() == 200){
            return true;
        }
        return false;
    }
}
