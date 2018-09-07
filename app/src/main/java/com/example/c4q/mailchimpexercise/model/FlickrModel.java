package com.example.c4q.mailchimpexercise.model;

import com.google.gson.annotations.SerializedName;

public class FlickrModel {
    @SerializedName("photos")
    private Photos photos;

    //getters
    public Photos getPhotos() {
        return photos;
    }

    //setters
    public void setPhotos(Photos photos) {
        this.photos = photos;
    }
}
