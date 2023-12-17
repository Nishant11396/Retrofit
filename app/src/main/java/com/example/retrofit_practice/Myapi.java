package com.example.retrofit_practice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Myapi {
    @GET("comments")
    Call<List<Model>> getdata();
}
