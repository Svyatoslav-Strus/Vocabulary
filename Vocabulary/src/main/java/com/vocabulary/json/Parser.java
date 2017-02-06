package com.vocabulary.json;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Strus Sviatoslav on 06.02.2017.
 */
public class Parser {
    private static OkHttpClient client = new OkHttpClient();

    private static String apikey = "5ff811aba5ce4e7f8e1888a3dd4fc180";

    private static String getJSON(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public ArrayList<Doc> getData(int year, int month){
        String json = null;
        try{
            json = getJSON("http://api.nytimes.com/svc/archive/v1/" + year + "/" + month + ".json?api-key=" + apikey);
        } catch (Exception e){
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Example example = gson.fromJson(json, Example.class);

        return (ArrayList<Doc>) example.getResponse().getDocs();
    }
}
