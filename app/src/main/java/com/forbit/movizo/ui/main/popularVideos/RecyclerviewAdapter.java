package com.forbit.movizo.ui.main.popularVideos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.forbit.movizo.R;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> {

    private Context context;
    private List<MovieList> movieLists;
    LayoutInflater inflater;

    public RecyclerviewAdapter(Context context, List<MovieList> movieLists) {
        this.context = context;
        this.movieLists = movieLists;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recyclerviewlayout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewAdapter.MyViewHolder holder, int position) {
        MovieList movieList = movieLists.get(position);
        holder.name.setText(movieList.getMovieName());
        holder.image.setImageResource(movieList.getMovieImage());
    }

    @Override
    public int getItemCount() {
        return movieLists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.MovieName);
            image = itemView.findViewById(R.id.MovieImage);
        }
    }
}