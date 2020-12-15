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

import java.util.ArrayList;

public class PopularVideosFragment extends Fragment {
    RecyclerviewAdapter recyclerviewAdapter;
    ArrayList<MovieList> movieLists;
    RecyclerView recyclerView;
    private TextView tvTitle;

    public PopularVideosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        movieLists = new ArrayList<>();
        for (int i=0;i<100;i++){
            movieLists.add(new MovieList(R.drawable.penguin, "Movie "+String.valueOf(i+1)));
        }
        recyclerviewAdapter = new RecyclerviewAdapter(getContext(),movieLists);
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

        return view;
    }

    public void setTitle(String title){
        tvTitle.setText(title);
    }
}
