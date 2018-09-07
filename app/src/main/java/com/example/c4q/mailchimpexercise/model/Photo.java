package com.example.c4q.mailchimpexercise.model;

import com.google.gson.annotations.SerializedName;

public class Photo {
    @SerializedName("isfamily")
    private int isfamily;
    @SerializedName("isfriend")
    private int isfriend;
    @SerializedName("ispublic")
    private int ispublic;
    @SerializedName("title")
    private String title;
    @SerializedName("farm")
    private int farm;
    @SerializedName("server")
    private String server;
    @SerializedName("secret")
    private String secret;
    @SerializedName("owner")
    private String owner;
    @SerializedName("id")
    private String id;

    // getters
    public int getIsfamily() {
        return isfamily;
    }

    public int getIsfriend() {
        return isfriend;
    }

    public int getIspublic() {
        return ispublic;
    }

    public String getTitle() {
        return title;
    }

    public int getFarm() {
        return farm;
    }

    public String getServer() {
        return server;
    }

    public String getSecret() {
        return secret;
    }

    public String getOwner() {
        return owner;
    }

    public String getId() {
        return id;
    }

    //setters
    public void setIsfamily(int isfamily) {
        this.isfamily = isfamily;
    }

    public void setIsfriend(int isfriend) {
        this.isfriend = isfriend;
    }

    public void setIspublic(int ispublic) {
        this.ispublic = ispublic;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFarm(int farm) {
        this.farm = farm;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setId(String id) {
        this.id = id;
    }
}
