package com.example.onur.movieexplorer.presentation.moviedetail;

import com.example.onur.movieexplorer.data.entity.MovieDetailEntity;
import com.example.onur.movieexplorer.data.entity.MovieEntity;
import com.example.onur.movieexplorer.domain.interactor.GetMovieDetail;
import com.example.onur.movieexplorer.domain.mapper.MovieDetailMapper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

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
    public void getMovieDetails() {
        view.showLoading();
        getMovieDetail.execute(new GetMovieDetail.Param(""), new Consumer<MovieDetailEntity>() {
            @Override
            public void accept(MovieDetailEntity movieDetailEntity) throws Exception {
                view.hideLoading();
                view.renderMovieDetails(movieDetailEntity);
            }
        });
    }
}
