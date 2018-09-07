package com.example.c4q.mailchimpexercise.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Photos {
    @SerializedName("photo")
    private List<Photo> photo;

    //getters
    public List<Photo> getPhoto() {
        return photo;
    }

    //setters
    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }
}
