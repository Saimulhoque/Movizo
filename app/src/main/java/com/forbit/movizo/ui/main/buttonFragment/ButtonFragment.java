package com.forbit.movizo.ui.main.buttonFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forbit.movizo.ui.main.categorie.CategoryActivity;
import com.forbit.movizo.R;
import com.forbitbd.myplayer.models.Category;
import com.forbitbd.myplayer.utils.Constant;

import java.util.List;

public class ButtonFragment extends Fragment implements View.OnClickListener, ButtonContract.View {

    private RecyclerView recyclerView;
    private CatAdapter adapter;
    private ButtonPresenter mPresenter;

    public ButtonFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new CatAdapter(getContext(),this);
        mPresenter = new ButtonPresenter(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_button, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setAdapter(adapter);
        mPresenter.getAllCategories();
        return view;

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void renderCategory(List<Category> categoryList) {
        for (Category x: categoryList){
            adapter.addCategory(x);
        }
    }

    @Override
    public void catClick(Category category) {
        Intent intent = new Intent(getContext(),CategoryActivity.class);
        intent.putExtra(Constant.CATEGORY,category);
        startActivity(intent);
    }
}
