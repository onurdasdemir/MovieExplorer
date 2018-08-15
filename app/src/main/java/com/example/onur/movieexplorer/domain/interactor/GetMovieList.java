package com.example.onur.movieexplorer.domain.interactor;

import com.example.onur.movieexplorer.data.entity.MovieEntity;
import com.example.onur.movieexplorer.data.source.MovieDataSource;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.Single;

public class GetMovieList extends UseCase<GetMovieList.Param, List<MovieEntity>> {

    private final MovieDataSource movieRepository;

    @Inject
    GetMovieList(MovieDataSource movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    Single<List<MovieEntity>> buildUseCase(Param params) {
        return movieRepository.getNowPlayingMovies();
    }

    public static final class Param{
    }
}