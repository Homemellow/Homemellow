package com.example.homemellow_app.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.homemellow_app.R;
import com.example.homemellow_app.data.PostsData;
import com.example.homemellow_app.data.StoreData;
import com.example.homemellow_app.data.StoreResponse;
import com.example.homemellow_app.network.RetrofitClient;
import com.example.homemellow_app.network.ServiceApi;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StoreActivity extends AppCompatActivity {
    private TextView nameText;
    private TextView costText;
    private ImageView itemImg;
    private ServiceApi service;
    private StoreData data;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.store_item);

            nameText = (TextView) findViewById(R.id.textView1);
            costText = (TextView) findViewById(R.id.textView2);
            itemImg = (ImageView) findViewById(R.id.imageView);

            service = RetrofitClient.getClient().create(ServiceApi.class);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://15.164.84.132:8080/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ServiceApi trendingInterface = retrofit.create(ServiceApi.class);

            loadData();

            //nameText.setText(data.getItemName());
            //costText.setText(data.getItemCost());
        }

        public void loadData() {
            String storeQuery = "query testquery { posts(where: {id: {_eq: \"1\"}}) { id\nimage\n}}";
            service.getStoreData(storeQuery).enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if(response.isSuccessful()){
                        System.out.println("Response");
                        ResponseBody responseBody = response.body();
                        try {
                            System.out.println("id :" + responseBody.string());
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    else
                    {
                        Log.d("connect","fail");
                    }

                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    System.out.println("failure");

                }
            });
        }
    }
