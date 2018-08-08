package com.example.onur.movieexplorer.data.source;

import com.example.onur.movieexplorer.data.entity.MovieDetailEntity;
import com.example.onur.movieexplorer.data.entity.MovieEntity;

import java.util.List;

import io.reactivex.Single;

public interface MovieDataSource {
    Single<List<MovieEntity>> getNowPlayingMovies();

    Single<MovieDetailEntity> getMovieDetails();

}
