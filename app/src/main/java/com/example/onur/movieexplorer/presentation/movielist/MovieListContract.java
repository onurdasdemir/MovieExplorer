package com.example.onur.movieexplorer.presentation.movielist;

import com.example.onur.movieexplorer.domain.model.MovieModel;
import com.example.onur.movieexplorer.presentation.BaseView;

import java.util.List;

public interface MovieListContract {

    interface View extends BaseView{
        void renderUpcomingMovies(List<MovieModel> movieModels);

        void navigateToDetails(String movieId);
    }

    interface Presenter{
        void takeView(View view);
        void dropView();
        void getUpComingMovies();

        void onMovieSelected(String movieId);
    }
}
