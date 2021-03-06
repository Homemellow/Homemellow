package com.example.homemellow_app.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.homemellow_app.R;
import com.example.homemellow_app.network.RetrofitClient;
import com.example.homemellow_app.network.ServiceApi;
import com.example.homemellow_app.data.JoinData;
import com.example.homemellow_app.data.JoinResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JoinActivity extends AppCompatActivity {
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private EditText mNameView;
    private EditText mHPNumView;
    private EditText mIdView;
    private Button mJoinButton;
    private ProgressBar mProgressView;
    private ServiceApi service;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        mEmailView = (AutoCompleteTextView) findViewById(R.id.join_email);
        mPasswordView = (EditText) findViewById(R.id.join_password);
        mNameView = (EditText) findViewById(R.id.join_name);
        mHPNumView = (EditText) findViewById(R.id.join_hp_num);
        mIdView = (EditText) findViewById(R.id.join_id);
        mJoinButton = (Button) findViewById(R.id.join_button);
        mProgressView = (ProgressBar) findViewById(R.id.join_progress);

        service = RetrofitClient.getClient().create(ServiceApi.class);

        mJoinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptJoin();
            }
        });
    }

    private void attemptJoin() {
        mNameView.setError(null);
        mEmailView.setError(null);
        mPasswordView.setError(null);

        String name = mNameView.getText().toString();
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();
        String hp_num = mHPNumView.getText().toString();
        String id = mIdView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // ??????????????? ????????? ??????
        if (password.isEmpty()) {
            mEmailView.setError("??????????????? ??????????????????!");
            focusView = mEmailView;
            cancel = true;
        } else if (!isPasswordValid(password)) {
            mPasswordView.setError("6??? ????????? ??????????????? ??????????????????!");
            focusView = mPasswordView;
            cancel = true;
        }

        // ???????????? ????????? ??????
        if (email.isEmpty()) {
            mEmailView.setError("???????????? ??????????????????!");
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError("@??? ????????? ????????? ???????????? ??????????????????!");
            focusView = mEmailView;
            cancel = true;
        }

        // ????????? ????????? ??????
        if (name.isEmpty()) {
            mNameView.setError("????????? ??????????????????.");
            focusView = mNameView;
            cancel = true;
        }

        // ???????????? ????????? ??????
        if (hp_num.isEmpty()) {
            mHPNumView.setError("????????? ??????????????????.");
            focusView = mHPNumView;
            cancel = true;
        }

        // ???????????? ????????? ??????
        if (id.isEmpty()) {
            mIdView.setError("????????? ??????????????????.");
            focusView = mIdView;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            startJoin(new JoinData(name, email, password, hp_num, id));
            showProgress(true);
        }
    }

    private void startJoin(JoinData data) {
//        service.userJoin(data).enqueue(new Callback<JoinResponse>() {
//            @Override
//            public void onResponse(Call<JoinResponse> call, Response<JoinResponse> response) {
//                JoinResponse result = response.body();
//                Toast.makeText(JoinActivity.this, result.getMessage(), Toast.LENGTH_SHORT).show();
//                showProgress(false);
//
//                if (result.getCode() == 200) {
//                    finish();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<JoinResponse> call, Throwable t) {
//                Toast.makeText(JoinActivity.this, "???????????? ?????? ??????", Toast.LENGTH_SHORT).show();
//                Log.e("???????????? ?????? ??????", t.getMessage());
//                showProgress(false);
//            }
//        });
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 6;
    }

    private void showProgress(boolean show) {
        mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}
