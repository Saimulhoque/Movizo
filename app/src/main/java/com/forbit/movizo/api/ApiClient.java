package com.forbit.movizo.api;

import com.forbit.movizo.model.Category;
import com.forbit.movizo.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiClient {


//        @POST("/api/api/tags")
//        Call<List<String>> getTags(@Body TagRequest tagRequest);

    @GET("/categories")
    Call<List<Category>> getAllCategories();


    @GET("/categories/{cat_id}/movies")
    Call<List<Movie>> getCategorizedMovies(@Path("cat_id") String catId);



    }

