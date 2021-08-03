package com.example.inshorts_news_app;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiClient {

    @GET("news")
    Call<ResponseModel> getPosts(@Query("category") String category);
}
