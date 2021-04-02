package com.example.homemellow_app.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.homemellow_app.R;
import com.example.homemellow_app.data.store.StoreResponse;
import com.example.homemellow_app.network.RetrofitClient;
import com.example.homemellow_app.network.ServiceApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoreActivity extends AppCompatActivity {
    private TextView nameText;
    private TextView costText;
    private ImageView itemImg;
    private ServiceApi service;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.store_item);

            nameText = (TextView) findViewById(R.id.textView1);
            costText = (TextView) findViewById(R.id.textView2);
            itemImg = (ImageView) findViewById(R.id.imageView);

            service = RetrofitClient.getClient().create(ServiceApi.class);

            loadData();
        }

        public void loadData() {

            String storeQuery = "query testquery {\n" +
                    "  users(where: {id: {_eq: \"testid@test.com\"}}) {\n" +
                    "    user_id\n" +
                    "    passwd\n" +
                    "    hp_num\n" +
                    "    nickname\n" +
                    "    id\n" +
                    "  }\n" +
                    "}\n" +
                    "\n";
            service.getStoreData(storeQuery).enqueue(new Callback<StoreResponse>() {
                @Override
                public void onResponse(Call<StoreResponse> call, Response<StoreResponse> response) {
                    if(response.isSuccessful()){
                        System.out.println("Response");
                        StoreResponse responseBody = response.body();
                        System.out.println("output :" + responseBody.getData().getPosts().get(0).toString());
                    }
                    else
                    {
                        Log.d("connect","fail");
                    }

                }

                @Override
                public void onFailure(Call<StoreResponse> call, Throwable t) {
                    System.out.println("failure");

                }
            });
        }
    }
