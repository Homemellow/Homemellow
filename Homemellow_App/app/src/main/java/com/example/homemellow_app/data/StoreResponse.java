package com.example.homemellow_app.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StoreResponse {

    @SerializedName("data")
    @Expose
    private String data;

    public String getData() {
        return data;
    }


}