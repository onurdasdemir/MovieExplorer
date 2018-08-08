package com.example.onur.movieexplorer.data.source.remote;

import com.example.onur.movieexplorer.data.entity.MovieDetailEntity;
import com.example.onur.movieexplorer.data.entity.MovieEntity;
import com.example.onur.movieexplorer.data.entity.MovieResponse;
import com.example.onur.movieexplorer.data.source.DataSourceModule;
import com.example.onur.movieexplorer.data.source.MovieDataSource;
import com.example.onur.movieexplorer.data.source.remote.network.MovieService;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import retrofit2.Retrofit;

public class MovieRemoteDataSource implements MovieDataSource {

    private final MovieService movieService;

    @Inject
    public MovieRemoteDataSource(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public Single<List<MovieEntity>> getNowPlayingMovies() {
        return movieService.getNowPlayingMovies().map(new Function<MovieResponse, List<MovieEntity>>() {
            @Override
            public List<MovieEntity> apply(MovieResponse movieResponse) {
                return movieResponse.getResults();
            }
        });
    }

    @Override
    public Single<MovieDetailEntity> getMovieDetails(String id) {
        return movieService.getMovieDetails(id);
    }

}
