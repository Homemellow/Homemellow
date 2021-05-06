package com.example.homemellow_app.data.store;

import com.example.homemellow_app.data.store.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StoreResponse {
    @SerializedName("data")
    @Expose
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}