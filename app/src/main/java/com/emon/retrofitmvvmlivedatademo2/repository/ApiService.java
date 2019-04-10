package com.emon.retrofitmvvmlivedatademo2.repository;

import com.emon.retrofitmvvmlivedatademo2.model.Model;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiService {
    String BaseUrl = "https://jsonplaceholder.typicode.com/";

    
    @GET("posts")
    Call<List<Model>> getPost();

    @GET("posts/{id}/comments")
    Call<List<Model>> getData(@Path("id") int postId);


    @GET ("photos")
    Call<List<Model>> getModel(@QueryMap Map<String,String> peramiters);

    @GET("photos")
    Call<List<Model>> getData(
            @Query("albumId") Integer[] userId,
            @Query("_sort") String sort,
            @Query("_order") String order
    );
}

