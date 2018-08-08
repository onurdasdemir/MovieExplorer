package com.example.onur.movieexplorer.presentation.moviedetail;

import com.example.onur.movieexplorer.presentation.movielist.MovieListContract;
import com.example.onur.movieexplorer.presentation.movielist.MovieListPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MovieDetailModule {

    @Binds
    abstract MovieDetailContract.Presenter bindPresenter(MovieDetailPresenter presenter);
}
