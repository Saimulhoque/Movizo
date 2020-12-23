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
import com.forbit.movizo.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> {

    private Context context;
    private List<Movie> movieList;
    LayoutInflater inflater;

    public RecyclerviewAdapter(Context context) {
        this.context = context;
        this.movieList = new ArrayList<>();
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
        Movie movie = movieList.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void add(Movie movie){
        movieList.add(movie);
        int position = movieList.indexOf(movie);
        notifyItemInserted(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.MovieName);
            image = itemView.findViewById(R.id.MovieImage);
        }

        public void bind(Movie movie){
            name.setText(movie.getTitle());
            if(movie.getImage_url()!=null || !movie.getImage_url().equals("")){
                Picasso.get().load(movie.getImage_url()).into(image);
            }
        }
    }
}