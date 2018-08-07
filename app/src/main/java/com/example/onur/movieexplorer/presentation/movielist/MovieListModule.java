package com.example.onur.movieexplorer.presentation.movielist;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MovieListModule {

    @Binds
    abstract MovieListContract.Presenter bindPresenter(MovieListPresenter presenter);
}
