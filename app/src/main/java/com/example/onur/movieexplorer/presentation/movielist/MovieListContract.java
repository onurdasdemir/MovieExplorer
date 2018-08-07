package com.example.onur.movieexplorer.presentation.movielist;

import com.example.onur.movieexplorer.domain.model.MovieModel;

import java.util.List;

public interface MovieListContract {

    interface View{
        void renderUpcomingMovies(List<MovieModel> movieModels);
    }

    interface Presenter{
        void takeView(View view);
        void dropView();
        void getUpComingMovies();
    }
}
