package com.example.homemellow_app.data.login;

import com.google.gson.annotations.SerializedName;

public class LoginData {
    @SerializedName("id")
    String userEmail;

    @SerializedName("passwd")
    String userPwd;

    public LoginData(String userEmail, String userPwd) {
        this.userEmail = userEmail;
        this.userPwd = userPwd;
    }
}


