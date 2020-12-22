package com.forbit.movizo.ui.main.categorie;

import android.util.Log;

import com.forbit.movizo.api.ApiClient;
import com.forbit.movizo.api.ServiceGenerator;
import com.forbit.movizo.model.Category;
import com.forbit.movizo.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryPresenter implements CategoryContract.Presenter {

    private CategoryContract.View mView;

    public CategoryPresenter(CategoryContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getCategorizedMovies(Category category) {
        mView.showProgressDialog();
        ApiClient client = ServiceGenerator.createService(ApiClient.class);
        client.getCategorizedMovies(category.get_id())
                .enqueue(new Callback<List<Movie>>() {
                    @Override
                    public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                        mView.hideProgressDialog();
                        if(response.isSuccessful()){
                            mView.renderMovies(response.body());

                            Log.d("UUUUUUU",response.body().size()+"");
                        }else {
                            Log.d("UUUUUUU","Errror");
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Movie>> call, Throwable t) {
                        mView.hideProgressDialog();
                        Log.d("UUUUUUU","Errror "+t.getMessage());
                    }
                });
    }
}
