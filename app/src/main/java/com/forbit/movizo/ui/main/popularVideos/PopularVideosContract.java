package com.forbit.movizo.ui.main.popularVideos;

import com.forbit.movizo.model.Movie;

import java.util.List;

public interface PopularVideosContract {

    interface Presenter{
        void getPopularMovies();
    }

    interface View{
        void renderMovies(List<Movie> movieList);

    }
}
