package com.example.onur.movieexplorer.domain.model;

public class MovieModel {

    private String name;
    private String imageUri;
    private double rating;
    private String id;

    public MovieModel(String name,String imageUri,double rating) {
        this.name = name;
        this.imageUri=imageUri;
        this.rating=rating;

    }

    public String getName() {
        return name;
    }

    public String getImageUri() {
        return String.format("%s%s", "https://image.tmdb.org/t/p/w500", imageUri);
    }

    public String getId() {
        return id;
    }

    public double getRating(){
        return getRating();
    }

    @Override
    public String toString() {
        return "MovieModel{" +
                "name='" + name + '\'' +
                '}';
    }
}
