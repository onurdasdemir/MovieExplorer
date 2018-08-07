package com.example.onur.movieexplorer.presentation.movielist;

import com.example.onur.movieexplorer.data.entity.MovieEntity;
import com.example.onur.movieexplorer.domain.interactor.GetMovieList;
import com.example.onur.movieexplorer.domain.mapper.MovieMapper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

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
        getMovieList.execute(new GetMovieList.Param(), new Consumer<List<MovieEntity>>() {
            @Override
            public void accept(List<MovieEntity> movieEntities) throws Exception {
                view.renderUpcomingMovies(movieMapper.toMoviModelList(movieEntities));
            }
        });
    }
}
