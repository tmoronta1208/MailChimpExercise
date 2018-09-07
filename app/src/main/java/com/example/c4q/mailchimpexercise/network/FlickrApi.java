package com.example.c4q.mailchimpexercise.network;

import com.example.c4q.mailchimpexercise.model.Photos;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FlickrApi {
//https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=698e1302856e60e61b87e5dd9d14f458&text=anime&safe_search=1&format=json&nojsoncallback=1

    @GET("rest/?method=flickr.photos.search&api_key=698e1302856e60e61b87e5dd9d14f458&text=anime&safe_search=1&format=json&nojsoncallback=1")
    Call<Photos> getPhotoList();
}
