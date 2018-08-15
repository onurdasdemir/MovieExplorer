package com.example.onur.movieexplorer.domain.mapper;

import com.example.onur.movieexplorer.data.entity.MovieEntity;
import com.example.onur.movieexplorer.domain.model.MovieModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MovieMapper {

    @Inject
    public MovieMapper() {
    }

    public List<MovieModel> toMovieModelList(List<MovieEntity> movieEntities){
        ArrayList<MovieModel> list = new ArrayList<>();
        for (MovieEntity entity : movieEntities){
            list.add(toMovieModel(entity));
        }
        return list;
    }

    private MovieModel toMovieModel(MovieEntity movieEntity){
        return new MovieModel(movieEntity.getOriginalTitle(),
                movieEntity.getPosterPath(),
                movieEntity.getVoteAverage(),
                movieEntity.getId());
    }
}
