package com.example.homemellow_app.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.homemellow_app.R;
import com.example.homemellow_app.data.StoreData;
import com.example.homemellow_app.data.StoreResponse;
import com.example.homemellow_app.network.RetrofitClient;
import com.example.homemellow_app.network.ServiceApi;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

            loadData();

            //nameText.setText(data.getItemName());
            //costText.setText(data.getItemCost());
        }

        public void loadData() {
            String storeQuery = "query testquery { posts(where: {id: {_eq: \"1\"}}) { id\nimage\ncomments{id\nuser_id\nbody_content}}}";
            service.storeData(storeQuery).enqueue(new Callback<StoreResponse>() {
                @Override
                public void onResponse(Call<StoreResponse> call, Response<StoreResponse> response) {
                    System.out.println("Response");
                    System.out.println("id :" + response.body().getId());
                    System.out.println("image :" + response.body().getImage());
                }

                @Override
                public void onFailure(Call<StoreResponse> call, Throwable t) {
                    System.out.println("failure");

                }
            });
        }
    }
