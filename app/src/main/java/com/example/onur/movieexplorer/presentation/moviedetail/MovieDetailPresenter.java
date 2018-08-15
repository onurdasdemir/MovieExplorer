package com.example.onur.movieexplorer.presentation.moviedetail;

import com.example.onur.movieexplorer.data.entity.MovieDetailEntity;
import com.example.onur.movieexplorer.domain.Callback;
import com.example.onur.movieexplorer.domain.interactor.GetMovieDetail;
import com.example.onur.movieexplorer.domain.mapper.MovieDetailMapper;

import javax.inject.Inject;

public class MovieDetailPresenter implements MovieDetailContract.Presenter{

    private final GetMovieDetail getMovieDetail;
    private final MovieDetailMapper movieDetailMapper;
    private MovieDetailContract.View view;

    @Inject
    public MovieDetailPresenter(GetMovieDetail getMovieDetail, MovieDetailMapper movieDetailMapper) {
        this.getMovieDetail = getMovieDetail;
        this.movieDetailMapper = movieDetailMapper;
    }

    @Override
    public void takeView(MovieDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void dropView() {
        getMovieDetail.dispose();
        this.view = null;
    }

    @Override
    public void getMovieDetails(String movieId) {
        view.showLoading();
        getMovieDetail.execute(new GetMovieDetail.Param(movieId), new Callback<MovieDetailEntity>() {
            @Override
            public void onSuccess(MovieDetailEntity movieDetailEntity) {
                view.hideLoading();
                view.renderMovieDetails(movieDetailMapper.toMovieDetailModel(movieDetailEntity));
            }

            @Override
            public void onError(Throwable throwable) {
                view.hideLoading();
                view.showError(throwable.getMessage());
            }
        });
    }

}
