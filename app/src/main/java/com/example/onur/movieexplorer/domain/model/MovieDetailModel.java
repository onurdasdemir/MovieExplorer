package com.example.onur.movieexplorer.domain.model;

public class MovieDetailModel {


    private String imageUri;
    private String overView;
    private String originalTitle;
    private String releaseDate;
    private int runTime;

    public MovieDetailModel(String overView,String imageUri,String originalTitle,String releaseDate,int runTime) {
        this.overView = overView;
        this.imageUri= imageUri;
        this.originalTitle=originalTitle;
        this.releaseDate=releaseDate;
        this.runTime=runTime;
    }

    public String getImageUri() {
        return String.format("%s%s", "https://image.tmdb.org/t/p/w500", imageUri);
    }

    public String getOverView() {
        return overView;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public int getRunTime() {
        return runTime;
    }
}
