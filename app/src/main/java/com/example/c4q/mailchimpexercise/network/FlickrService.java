package com.example.c4q.mailchimpexercise.network;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FlickrService {
    private static final String BASE_URL = "https://api.flickr.com/";

    private final Retrofit retrofit;

    public FlickrService() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @NonNull
    public FlickrApi getFlickrApi() {
        return retrofit.create(FlickrApi.class);
    }
}
