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

    public List<MovieModel> toMoviModelList(List<MovieEntity> movieEntities){
        ArrayList<MovieModel> list = new ArrayList<>();
        for (MovieEntity entity : movieEntities){
            list.add(toMovieModel(entity));
        }
        return list;
    }

    public MovieModel toMovieModel(MovieEntity movieEntity){
        return new MovieModel(movieEntity.getOriginalTitle());
    }
}
