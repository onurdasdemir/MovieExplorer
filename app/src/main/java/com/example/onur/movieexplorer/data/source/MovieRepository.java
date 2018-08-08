package com.example.onur.movieexplorer.data.source;

import com.example.onur.movieexplorer.data.entity.MovieDetailEntity;
import com.example.onur.movieexplorer.data.entity.MovieEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.functions.Predicate;

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
                        return !movieEntities.isEmpty();
                    }
                }).firstOrError();
    }

    @Override
    public Single<MovieDetailEntity> getMovieDetails(String id) {
        return Single.concat(localMovieDataSource.getMovieDetails(id),remoteMovieDataSource.getMovieDetails(id)).filter(new Predicate<MovieDetailEntity>() {
            @Override
            public boolean test(MovieDetailEntity movieDetailEntity) throws Exception {
                return movieDetailEntity!=null;
            }
        }).firstOrError();
    }
}
