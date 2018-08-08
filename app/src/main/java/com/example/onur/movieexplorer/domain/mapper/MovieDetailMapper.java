package com.example.onur.movieexplorer.domain.mapper;

import com.example.onur.movieexplorer.data.entity.MovieDetailEntity;
import com.example.onur.movieexplorer.domain.model.MovieDetailModel;

import javax.inject.Inject;

public class MovieDetailMapper {


    @Inject
    public MovieDetailMapper() {
    }

    public MovieDetailModel toMovieDetailModel (MovieDetailEntity detailEntity){
        return new MovieDetailModel(detailEntity.overview,detailEntity.posterPath,detailEntity.originalTitle,detailEntity.releaseDate,detailEntity.runtime);
    }

}
