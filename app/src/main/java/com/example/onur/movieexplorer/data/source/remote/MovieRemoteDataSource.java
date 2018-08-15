package com.example.onur.movieexplorer.data.source.remote;

import com.example.onur.movieexplorer.data.entity.MovieDetailEntity;
import com.example.onur.movieexplorer.data.entity.MovieEntity;
import com.example.onur.movieexplorer.data.entity.MovieResponse;
import com.example.onur.movieexplorer.data.source.MovieDataSource;
import com.example.onur.movieexplorer.data.source.local.Cache;
import com.example.onur.movieexplorer.data.source.remote.network.MovieService;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

@Singleton
public class MovieRemoteDataSource implements MovieDataSource {

    private final MovieService movieService;
    private final Cache cache;

    @Inject
    public MovieRemoteDataSource(MovieService movieService, Cache cache) {
        this.movieService = movieService;
        this.cache = cache;
    }

    @Override
    public Single<List<MovieEntity>> getNowPlayingMovies() {
        return movieService.getNowPlayingMovies().map(new Function<MovieResponse, List<MovieEntity>>() {
            @Override
            public List<MovieEntity> apply(MovieResponse movieResponse) {
                return movieResponse.getResults();
            }
        }).doAfterSuccess(new Consumer<List<MovieEntity>>() {
            @Override
            public void accept(List<MovieEntity> movieEntities) {
                cache.cacheMovies(movieEntities);
            }
        });
    }

    @Override
    public Single<MovieDetailEntity> getMovieDetails(String id) {
        return movieService.getMovieDetails(id)
                .doAfterSuccess(new Consumer<MovieDetailEntity>() {
                    @Override
                    public void accept(MovieDetailEntity movieDetailEntity) {
                        cache.cacheMovieDetail(movieDetailEntity);
                    }
                });
    }

}
