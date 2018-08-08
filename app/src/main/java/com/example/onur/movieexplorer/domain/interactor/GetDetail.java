package com.example.onur.movieexplorer.domain.interactor;

import com.example.onur.movieexplorer.data.entity.MovieDetailEntity;
import com.example.onur.movieexplorer.data.source.MovieDataSource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class GetDetail extends UseCase<GetDetail.Param, MovieDetailEntity> {

    private final MovieDataSource movieRepository;

    @Inject
    GetDetail(MovieDataSource movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    Single<MovieDetailEntity> buildUseCase(GetDetail.Param params) {
        return movieRepository.getMovieDetails();
    }

    public static final class Param{

    }
}
