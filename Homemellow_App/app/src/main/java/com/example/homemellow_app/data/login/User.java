
package com.example.homemellow_app.data.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("passwd")
    @Expose
    private String passwd;
    @SerializedName("hp_num")
    @Expose
    private Object hpNum;
    @SerializedName("nickname")
    @Expose
    private Object nickname;
    @SerializedName("id")
    @Expose
    private String id;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Object getHpNum() {
        return hpNum;
    }

    public void setHpNum(Object hpNum) {
        this.hpNum = hpNum;
    }

    public Object getNickname() {
        return nickname;
    }

    public void setNickname(Object nickname) {
        this.nickname = nickname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}