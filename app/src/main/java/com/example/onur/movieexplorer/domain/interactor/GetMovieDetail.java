package com.example.onur.movieexplorer.domain.interactor;

import com.example.onur.movieexplorer.data.entity.MovieDetailEntity;
import com.example.onur.movieexplorer.data.source.MovieDataSource;

import javax.inject.Inject;

import io.reactivex.Single;

public class GetMovieDetail extends UseCase<GetMovieDetail.Param, MovieDetailEntity> {

    private final MovieDataSource movieRepository;

    @Inject
    GetMovieDetail(MovieDataSource movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    Single<MovieDetailEntity> buildUseCase(GetMovieDetail.Param params) {
        return movieRepository.getMovieDetails(params.id);
    }

    public static final class Param{
        private final String id;

        public Param(String id) {
            this.id = id;
        }
    }
}
