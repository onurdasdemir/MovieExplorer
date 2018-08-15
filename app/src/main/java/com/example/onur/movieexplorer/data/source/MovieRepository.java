package com.example.onur.movieexplorer.data.source;

import android.util.Log;

import com.example.onur.movieexplorer.data.entity.MovieDetailEntity;
import com.example.onur.movieexplorer.data.entity.MovieEntity;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import io.reactivex.functions.Predicate;

@Singleton
public class MovieRepository implements MovieDataSource {

    private final MovieDataSource remoteMovieDataSource;
    private final MovieDataSource localMovieDataSource;

    @Inject
    MovieRepository(@Remote MovieDataSource remoteMovieDataSource, @Local MovieDataSource localMovieDataSource) {
        this.remoteMovieDataSource = remoteMovieDataSource;
        this.localMovieDataSource = localMovieDataSource;
    }

    @Override
    public Single<List<MovieEntity>> getNowPlayingMovies() {
        return Single.concat(localMovieDataSource.getNowPlayingMovies(), remoteMovieDataSource.getNowPlayingMovies())
                .filter(new Predicate<List<MovieEntity>>() {
                    @Override
                    public boolean test(List<MovieEntity> movieEntities) {
                        return !movieEntities.isEmpty()
                                && movieEntities.get(0).isFresh(TimeUnit.MINUTES, 10);
                    }
                }).firstOrError();
    }

    @Override
    public Single<MovieDetailEntity> getMovieDetails(String id) {
        return Single.concat(localMovieDataSource
                .getMovieDetails(id),remoteMovieDataSource
                .getMovieDetails(id)).filter(new Predicate<MovieDetailEntity>() {
            @Override
            public boolean test(MovieDetailEntity movieDetailEntity) {
                boolean isFresh = movieDetailEntity.isFresh(TimeUnit.MINUTES, 10);
                Log.i("Fresh", String.valueOf(isFresh));
                return isFresh;
            }
        }).firstOrError();
    }
}
