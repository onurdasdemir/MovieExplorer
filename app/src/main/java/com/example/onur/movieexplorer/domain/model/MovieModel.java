package com.example.onur.movieexplorer.domain.model;

public class MovieModel {

    private String name;

    public MovieModel(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MovieModel{" +
                "name='" + name + '\'' +
                '}';
    }
}
