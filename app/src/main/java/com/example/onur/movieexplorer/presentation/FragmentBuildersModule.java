package com.example.onur.movieexplorer.presentation;

import com.example.onur.movieexplorer.di.FragmentScope;
import com.example.onur.movieexplorer.presentation.moviedetail.MovieDetailFragment;
import com.example.onur.movieexplorer.presentation.moviedetail.MovieDetailModule;
import com.example.onur.movieexplorer.presentation.movielist.MovieListFragment;
import com.example.onur.movieexplorer.presentation.movielist.MovieListModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = MovieListModule.class)
    abstract MovieListFragment conributeMovieListFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = MovieDetailModule.class)
    abstract MovieDetailFragment conributeMovieDetailFragment();

}
