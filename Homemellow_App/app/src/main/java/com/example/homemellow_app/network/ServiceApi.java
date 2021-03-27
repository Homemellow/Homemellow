package com.example.homemellow_app.network;

import com.example.homemellow_app.data.JoinData;
import com.example.homemellow_app.data.JoinResponse;
import com.example.homemellow_app.data.LoginData;
import com.example.homemellow_app.data.LoginResponse;
import com.example.homemellow_app.data.StoreResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ServiceApi {

    @POST("/v1/graphql")
    Call<StoreResponse> storeData(@Query("query") String toreQuery);

    @POST("/v1/graphql")
    Call<LoginResponse> userLogin(@Body LoginData data);

    @POST("/users/register")
    Call<JoinResponse> userJoin(@Body JoinData data);

}