package com.example.onur.movieexplorer.domain.mapper;

import com.example.onur.movieexplorer.data.entity.MovieDetailEntity;
import com.example.onur.movieexplorer.domain.model.MovieDetailModel;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MovieDetailMapper {

    @Inject
    MovieDetailMapper() {
    }

    public MovieDetailModel toMovieDetailModel (MovieDetailEntity detailEntity){
        return new MovieDetailModel(detailEntity.getOverview(),
                detailEntity.getPosterPath(),
                detailEntity.getOriginalTitle(),
                detailEntity.getReleaseDate(),
                String.valueOf(detailEntity.getRuntime()));
    }

}
