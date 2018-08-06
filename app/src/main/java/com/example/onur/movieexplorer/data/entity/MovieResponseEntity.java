package com.example.onur.movieexplorer.data.entity;

import java.util.List;

public class MovieResponseEntity {

    private List<MovieEntity> results = null;

    private Integer page;

    private Integer totalResults;

    public List<MovieEntity> getResults() {
        return results;
    }

}
