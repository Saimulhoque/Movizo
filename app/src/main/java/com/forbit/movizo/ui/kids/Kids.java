package com.forbit.movizo.ui.kids;

public class Kids {

    Integer MovieImage;
    String MovieName;

    public Kids(Integer movieImage, String movieName) {
        MovieImage = movieImage;
        MovieName = movieName;
    }

    public Integer getMovieImage() {
        return MovieImage;
    }

    public void setMovieImage(Integer movieImage) {
        MovieImage = movieImage;
    }

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }
}
