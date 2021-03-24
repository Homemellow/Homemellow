package com.example.homemellow_app.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Endpoint.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    HasuraAuthInterface auth = retrofit.create(HasuraAuthInterface.class);

    auth.login(new AuthRequest(username, password)).enqueue(new Callback<AuthResponse>() {
        @Override
        public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
            if (response.isSuccessful()) {
                AuthResponse authResponse = response.body();
                //Handle Response
            } else {
                //Handle Error
            }
        }

        @Override
        public void onFailure(Call<AuthResponse> call, Throwable t) {
            //Handle Failure
        }
    });
}
