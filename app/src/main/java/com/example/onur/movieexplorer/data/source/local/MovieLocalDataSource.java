package com.example.onur.movieexplorer.data.source.local;

import android.util.LruCache;

import com.example.onur.movieexplorer.data.entity.MovieDetailEntity;
import com.example.onur.movieexplorer.data.entity.MovieEntity;
import com.example.onur.movieexplorer.data.source.MovieDataSource;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class MovieLocalDataSource implements MovieDataSource, Cache {

    private static final String KEY_MOVIES = "movies";
    private static final String KEY_MOVIE_DETAILS = "movie_details";
    private LruCache<String, Object> lruCache = new LruCache<>(1024 * 1024 * 10);

    @Inject
    public MovieLocalDataSource() {
    }

    @Override
    public Single<List<MovieEntity>> getNowPlayingMovies() {
        List<MovieEntity> movieEntities = getItemFromCache(KEY_MOVIES, Collections.<MovieEntity>emptyList());
        return Single.just(movieEntities);
    }

    @Override
    public Single<MovieDetailEntity> getMovieDetails(String id) {
        MovieDetailEntity entity = getItemFromCache(KEY_MOVIE_DETAILS + id, MovieDetailEntity.empty());
        return Single.just(entity);
    }


    @Override
    public void cacheMovies(List<MovieEntity> nowPlayingMovies) {
        lruCache.put(KEY_MOVIES, nowPlayingMovies);
    }

    @Override
    public void cacheMovieDetail(MovieDetailEntity movieDetailEntity) {
        lruCache.put(KEY_MOVIE_DETAILS + movieDetailEntity.getId(), movieDetailEntity);
    }

    private <T> T getItemFromCache(String key, T defaultValue){
        Object o =  lruCache.get(key);
        if (o == null)
            return defaultValue;
        //noinspection unchecked
        return (T) o;
    }
}
