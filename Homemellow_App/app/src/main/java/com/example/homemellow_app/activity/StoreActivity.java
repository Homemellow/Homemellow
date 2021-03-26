package com.example.homemellow_app.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.homemellow_app.R;
import com.example.homemellow_app.data.StoreData;
import com.example.homemellow_app.data.StoreResponse;
import com.example.homemellow_app.network.APIInterface;
import com.example.homemellow_app.network.Endpoint;
import com.ramkishorevs.graphqlconverter.converter.GraphQLConverter;
import com.ramkishorevs.graphqlconverter.converter.QueryContainerBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class StoreActivity extends AppCompatActivity {
    private TextView nameText;
    private TextView costText;
    private ImageView itemImg;
    private APIInterface service;
    private Retrofit retrofitclient;
    private HttpLoggingInterceptor logging;
    private Retrofit apiInterface;
    private QueryContainerBuilder queryContainer;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.store_item);

            nameText = (TextView) findViewById(R.id.textView1);
            costText = (TextView) findViewById(R.id.textView2);
            itemImg = (ImageView) findViewById(R.id.imageView);

            logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build();

            retrofitclient = new Retrofit.Builder()
                    .baseUrl(Endpoint.BASE_URL)
                    .addConverterFactory(GraphQLConverter.create(this))
                    .client(client)
                    .build();

            service = retrofitclient.create(APIInterface.class);

            queryContainer = QueryContainerBuilder();
            queryContainer.putVariable("id",1);

            loadData("1");

            //nameText.setText(data.getItemName());
            //costText.setText(data.getItemCost());
        }

        public void loadData(String name) {
            service.getResponse().enqueue(new Callback<StoreResponse>() {
                @Override
                public void onResponse(Call<StoreResponse> call, Response<StoreResponse> response) {
                    System.out.println("Response");
                    System.out.println("name :" + response.body().getName());
                    System.out.println("cost :" + response.body().getCost());
                }

                @Override
                public void onFailure(Call<StoreResponse> call, Throwable t) {
                    System.out.println("failure");

                }
            });
        }
    }
