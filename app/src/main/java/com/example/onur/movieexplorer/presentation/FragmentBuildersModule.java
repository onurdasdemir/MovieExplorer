package com.example.onur.movieexplorer.presentation;

import com.example.onur.movieexplorer.presentation.movielist.MovieListFragment;
import com.example.onur.movieexplorer.presentation.movielist.MovieListModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {

    @ContributesAndroidInjector(modules = MovieListModule.class)
    abstract MovieListFragment conributeMovieListFragment();
}
