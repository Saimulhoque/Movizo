package com.forbit.movizo.ui.main.buttonFragment;

import com.forbit.movizo.api.ApiClient;
import com.forbit.movizo.api.ServiceGenerator;
import com.forbitbd.myplayer.models.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ButtonPresenter implements ButtonContract.Presenter {

    private ButtonContract.View mView;
    public ButtonPresenter(ButtonContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getAllCategories() {
        ApiClient client = ServiceGenerator.createService(ApiClient.class);

        client.getAllCategories()
                .enqueue(new Callback<List<Category>>() {
                    @Override
                    public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                        if(response.isSuccessful()){
                            mView.renderCategory(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Category>> call, Throwable t) {

                    }
                });
    }
}
