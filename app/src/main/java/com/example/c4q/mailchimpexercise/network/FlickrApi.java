package com.example.c4q.mailchimpexercise.network;

import com.example.c4q.mailchimpexercise.model.FlickrModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FlickrApi {
    String API_KEY = "api_key=698e1302856e60e61b87e5dd9d14f458";

    @GET("services/rest/?method=flickr.photos.search&" + API_KEY + "&safe_search=1&format=json&nojsoncallback=1")
    Call<FlickrModel> getPhotoList(@Query("text") String search);
}
