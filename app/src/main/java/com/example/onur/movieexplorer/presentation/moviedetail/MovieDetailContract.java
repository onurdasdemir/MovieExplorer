package com.example.onur.movieexplorer.presentation.moviedetail;

import com.example.onur.movieexplorer.domain.model.MovieDetailModel;
import com.example.onur.movieexplorer.presentation.BaseView;

public interface MovieDetailContract {

    interface View extends BaseView {
        void renderMovieDetails(MovieDetailModel movieDetailModel);
    }

    interface Presenter{
        void takeView(MovieDetailContract.View view);
        void dropView();
        void getMovieDetails(String movieId);
    }
}
