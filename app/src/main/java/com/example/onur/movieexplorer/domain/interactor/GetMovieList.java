package com.example.onur.movieexplorer.domain.interactor;

import com.example.onur.movieexplorer.data.entity.MovieEntity;
import com.example.onur.movieexplorer.data.source.MovieRepository;

import java.util.List;

import io.reactivex.Single;

public class GetMovieList extends UseCase<GetMovieList.Param, List<MovieEntity>> {

    private final MovieRepository movieRepository;

    public GetMovieList(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    Single<List<MovieEntity>> buildUseCase(Param params) {
        return movieRepository.getNowPlayingMovies();
    }

    public static final class Param{

    }
}