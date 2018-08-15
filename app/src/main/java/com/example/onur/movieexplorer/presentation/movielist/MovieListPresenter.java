package com.example.onur.movieexplorer.presentation.movielist;

import com.example.onur.movieexplorer.data.entity.MovieEntity;
import com.example.onur.movieexplorer.domain.Callback;
import com.example.onur.movieexplorer.domain.interactor.GetMovieList;
import com.example.onur.movieexplorer.domain.mapper.MovieMapper;

import java.util.List;

import javax.inject.Inject;

public class MovieListPresenter implements MovieListContract.Presenter{

    private final GetMovieList getMovieList;
    private final MovieMapper movieMapper;
    private MovieListContract.View view;

    @Inject
    public MovieListPresenter(GetMovieList getMovieList, MovieMapper movieMapper) {
        this.getMovieList = getMovieList;
        this.movieMapper = movieMapper;
    }

    @Override
    public void takeView(MovieListContract.View view) {
        this.view = view;
    }

    @Override
    public void dropView() {
        getMovieList.dispose();
        this.view = null;
    }

    @Override
    public void getUpComingMovies() {
        view.showLoading();
        getMovieList.execute(new GetMovieList.Param(), new Callback<List<MovieEntity>>() {
            @Override
            public void onSuccess(List<MovieEntity> movieEntities) {
                view.hideLoading();
                view.renderUpcomingMovies(movieMapper.toMovieModelList(movieEntities));
            }

            @Override
            public void onError(Throwable throwable) {
                view.hideLoading();
                view.showError(throwable.getMessage());
            }
        });
    }

    @Override
    public void onMovieSelected(String movieId) {
        view.navigateToDetails(movieId);
    }
}
