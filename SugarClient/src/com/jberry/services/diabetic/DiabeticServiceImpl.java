package com.jberry.services.diabetic;

import com.google.gson.Gson;
import com.jberry.dto.Diabetic;
import com.jberry.dto.User;
import com.jberry.services.tools.ToolService;
import com.jberry.services.tools.ToolServiceFactory;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class DiabeticServiceImpl implements DiabeticService{
    @Override
    public boolean postDiabeticInfo(Diabetic DiabeticUsr, String userId) throws IOException{
        String url = "http://localhoast:3000/api/postRatio";
        ToolService toolService = ToolServiceFactory.getToolService();

        Gson jesus = new Gson();
        String ans = jesus.toJson(DiabeticUsr);

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        post.setHeader("Authorization", "Basic " + toolService.userEncoded());
        post.setHeader("Content-type", "application/json");
        post.setEntity(new StringEntity(ans));

        HttpResponse response = client.execute(post);
        response = client.execute(post);
        if (response.getStatusLine().getStatusCode() == 200){
            return true;
        }
        return false;
    }

    @Override
    public Diabetic getDiabeticInfo(String userId) throws IOException {
        String url = "http://localhost:3000/api/getRatio/" + userId;

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

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

        Gson jesus = new Gson();

        return jesus.fromJson(output, Diabetic.class);
    }
}
