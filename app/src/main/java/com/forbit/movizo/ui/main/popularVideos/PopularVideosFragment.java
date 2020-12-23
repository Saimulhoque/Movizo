package com.forbit.movizo.ui.main.popularVideos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.forbit.movizo.R;
import com.forbit.movizo.model.Movie;

import java.util.List;


public class PopularVideosFragment extends Fragment implements PopularVideosContract.View {
    RecyclerviewAdapter recyclerviewAdapter;
    RecyclerView recyclerView;
    private TextView tvTitle;

    private PopularVideosPresenter mPresenter;

    public PopularVideosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new PopularVideosPresenter(this);
        recyclerviewAdapter = new RecyclerviewAdapter(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popular_videos, container, false);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerviewAdapter);
        tvTitle = view.findViewById(R.id.title);


        mPresenter.getPopularMovies();

        return view;
    }

    public void setTitle(String title){
        tvTitle.setText(title);
    }

    @Override
    public void renderMovies(List<Movie> movieList) {
        for (Movie x: movieList){
            recyclerviewAdapter.add(x);
        }
    }
}
