package com.example.onur.movieexplorer.presentation.moviedetail;

import com.example.onur.movieexplorer.di.FragmentScope;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MovieDetailModule {

    @FragmentScope
    @Binds
    abstract MovieDetailContract.Presenter bindPresenter(MovieDetailPresenter presenter);
}
