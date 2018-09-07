package com.example.c4q.mailchimpexercise.model

import com.google.gson.annotations.SerializedName

class Photo {
    @SerializedName("isfamily")
    val isfamily: Int = 0
    @SerializedName("isfriend")
    val isfriend: Int = 0
    @SerializedName("ispublic")
    val ispublic: Int = 0
    @SerializedName("title")
    val title: String? = null
    @SerializedName("farm")
    val farm: Int = 0
    @SerializedName("server")
    val server: String? = null
    @SerializedName("secret")
    val secret: String? = null
    @SerializedName("owner")
    val owner: String? = null
    @SerializedName("id")
    val id: String? = null
}
