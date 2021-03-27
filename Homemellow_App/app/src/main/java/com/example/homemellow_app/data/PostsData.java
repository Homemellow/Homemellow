package com.example.homemellow_app.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostsData {

    @SerializedName("posts")
    @Expose
    private List<StoreData> posts = null;

    public List<StoreData> getPosts() {
        return posts;
    }

    public void setPosts(List<StoreData> posts) {
        this.posts = posts;
    }

}