package com.example.onur.movieexplorer.domain.model;

public class MovieModel {

    private String name;
    private String imageUri;

    public MovieModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getImageUri() {
        return imageUri;
    }

    @Override
    public String toString() {
        return "MovieModel{" +
                "name='" + name + '\'' +
                '}';
    }
}
