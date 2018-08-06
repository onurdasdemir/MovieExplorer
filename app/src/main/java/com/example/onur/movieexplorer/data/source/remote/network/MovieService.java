package com.example.onur.movieexplorer.data.source.remote.network;

import com.example.onur.movieexplorer.data.entity.MovieResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface MovieService {
    @GET("/movie")
    Single<MovieResponse> getNowPlayingMovies();
}
