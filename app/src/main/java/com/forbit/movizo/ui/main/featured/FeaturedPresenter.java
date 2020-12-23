package com.forbit.movizo.ui.main.featured;

import com.forbit.movizo.api.ApiClient;
import com.forbit.movizo.api.ServiceGenerator;
import com.forbit.movizo.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeaturedPresenter implements FeaturedContract.Presenter {

    private FeaturedContract.View mView;

    public FeaturedPresenter(FeaturedContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getFeaturedMovies() {

        ApiClient client = ServiceGenerator.createService(ApiClient.class);

        client.getFeaturedMovies().enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if(response.isSuccessful()){
                    mView.renderMovies(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {

            }
        });

    }
}
