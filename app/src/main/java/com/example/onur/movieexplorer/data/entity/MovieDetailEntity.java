package com.example.onur.movieexplorer.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieDetailEntity {
    @SerializedName("adult")
    @Expose
    public Boolean adult;
    @SerializedName("backdrop_path")
    @Expose
    public String backdropPath;
    @SerializedName("genres")
    @Expose
    public List<MovieGenreEntity> genres = null;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("original_language")
    @Expose
    public String originalLanguage;
    @SerializedName("original_title")
    @Expose
    public String originalTitle;
    @SerializedName("overview")
    @Expose
    public String overview;
    @SerializedName("poster_path")
    @Expose
    public String posterPath;
    @SerializedName("release_date")
    @Expose
    public String releaseDate;
    @SerializedName("runtime")
    @Expose
    public Integer runtime;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("vote_average")
    @Expose
    public Double voteAverage;

}
