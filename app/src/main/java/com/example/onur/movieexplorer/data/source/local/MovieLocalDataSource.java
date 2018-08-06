package com.example.onur.movieexplorer.data.source.local;

import com.example.onur.movieexplorer.data.entity.MovieEntity;
import com.example.onur.movieexplorer.data.source.MovieDataSource;

import java.util.Collections;
import java.util.List;

import io.reactivex.Single;

public class MovieLocalDataSource implements MovieDataSource {

    private String s;

    @Override
    public Single<List<MovieEntity>> getNowPlayingMovies() {
        return Single.just(Collections.<MovieEntity>emptyList());
    }

    public void saveUser(String user){
        this.s = user;
    }
}
