package com.forbit.movizo.ui.main.popularVideos;

import com.forbit.movizo.api.ApiClient;
import com.forbit.movizo.api.ServiceGenerator;
import com.forbit.movizo.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularVideosPresenter implements PopularVideosContract.Presenter {

    private PopularVideosContract.View mView;

    public PopularVideosPresenter(PopularVideosContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getPopularMovies() {
        ApiClient client = ServiceGenerator.createService(ApiClient.class);

        client.getPopularMovies()
                .enqueue(new Callback<List<Movie>>() {
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
