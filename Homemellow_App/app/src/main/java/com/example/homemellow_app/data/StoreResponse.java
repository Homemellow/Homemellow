package com.example.homemellow_app.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StoreResponse {

    @SerializedName("id")
    private int id;
    @SerializedName("image")
    private String image;

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

}