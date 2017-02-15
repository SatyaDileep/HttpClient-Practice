package com.satyadileep.practice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.satyadileep.practice.model.ResponsePojo;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dillugadu on 15-02-2017.
 */
public class HttpClientPractice {

    public static void main(String[] args) {
        HttpClientPractice httpClientPractice = new HttpClientPractice();
        httpClientPractice.callGetMethod();
    }

    public void callGetMethod(){
        try{
            String url = "https://us14.api.mailchimp.com/3.0/lists?fields=lists.id,lists.name";
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("Accept","application/json");
            httpGet.setHeader("Authorization", "OAuth ");
            //httpGet.setHeader("Fields", "lists.id,lists.name");

            HttpResponse httpResponse = httpClient.execute(httpGet);
            if(httpResponse.getEntity()!=null){
                String responseString = EntityUtils.toString(httpResponse.getEntity());
                JSONObject jsonObject = new JSONObject(responseString);
                JSONArray jsonArray = jsonObject.getJSONArray("lists");

                List<ResponsePojo> responsePojoList = new ArrayList<ResponsePojo>();
                for(int i=0; i<jsonArray.length();i++){
                    JSONObject object = jsonArray.getJSONObject(i);
                    responsePojoList.add(unmarshallJson(object));
                }
                System.out.println("////");
                System.out.println(responsePojoList);
            }
        }
        catch (Exception e){

        }
    }

    private ResponsePojo unmarshallJson(JSONObject jsonObject) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(jsonObject.toString());
        return mapper.readValue(jsonObject.toString(), ResponsePojo.class);
    }
}
