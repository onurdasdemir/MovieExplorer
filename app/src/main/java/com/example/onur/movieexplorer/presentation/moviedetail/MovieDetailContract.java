package com.example.onur.movieexplorer.presentation.moviedetail;

import com.example.onur.movieexplorer.data.entity.MovieDetailEntity;
import com.example.onur.movieexplorer.presentation.BaseView;

public interface MovieDetailContract {

    interface View extends BaseView {
        void renderMovieDetails(MovieDetailEntity movieDetailEntity);
    }

    interface Presenter{
        void takeView(MovieDetailContract.View view);
        void dropView();
        void getMovieDetails();
    }
}
