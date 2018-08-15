package com.example.onur.movieexplorer.presentation.movielist;

import com.example.onur.movieexplorer.di.FragmentScope;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MovieListModule {

    @FragmentScope
    @Binds
    abstract MovieListContract.Presenter bindPresenter(MovieListPresenter presenter);
}
