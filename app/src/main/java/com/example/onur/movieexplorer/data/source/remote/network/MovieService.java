package com.example.onur.movieexplorer.data.source.remote.network;

import com.example.onur.movieexplorer.data.entity.MovieResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface MovieService {

    @GET("/movie/now_playing?api_key=97e74e00f803042c56420a57dc774253&language=en-US&page=1")
    Single<MovieResponse> getNowPlayingMovies();

}
