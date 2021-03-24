package com.example.homemellow_app.network;

import com.example.homemellow_app.data.JoinData;
import com.example.homemellow_app.data.JoinResponse;
import com.example.homemellow_app.data.LoginData;
import com.example.homemellow_app.data.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface HasuraAuthInterface {
    @POST(Endpoint.LOGIN)
    Call<LoginResponse> userLogin(@Body LoginData data);

    @POST(Endpoint.REGISTER)
    Call<JoinResponse> userJoin(@Body JoinData data);
}
