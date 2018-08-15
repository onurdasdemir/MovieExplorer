package com.example.onur.movieexplorer.data.source.local;

import com.example.onur.movieexplorer.data.entity.MovieDetailEntity;
import com.example.onur.movieexplorer.data.entity.MovieEntity;

import java.util.List;

import io.reactivex.Single;

public interface Cache {

    void cacheMovies(List<MovieEntity> nowPlayingMovies);

    void cacheMovieDetail(MovieDetailEntity getMovieDetails);
}
