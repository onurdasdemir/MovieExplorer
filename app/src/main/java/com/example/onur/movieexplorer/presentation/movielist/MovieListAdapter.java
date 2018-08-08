package com.example.onur.movieexplorer.presentation.movielist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.bumptech.glide.Glide;
import com.example.onur.movieexplorer.R;
import com.example.onur.movieexplorer.data.source.MovieRepository;
import com.example.onur.movieexplorer.domain.model.MovieModel;
import com.example.onur.movieexplorer.util.ObjectHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieHolder> {

   private List<MovieModel> movieModelList;

   @Inject
    public MovieListAdapter() {
        movieModelList = Collections.emptyList();
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);
        return new MovieHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        final MovieModel movieModel = movieModelList.get(position);
        holder.bind(movieModel);
    }

    @Override
    public int getItemCount() {
        return movieModelList.size();
    }

    public void setMovieModelList(List<MovieModel> movieModelList) {
        this.movieModelList = ObjectHelper.checkNotNull(movieModelList);
        this.notifyDataSetChanged();
    }

    static class MovieHolder extends RecyclerView.ViewHolder {
        MovieHolder(View itemView) {
            super(itemView);
        }

        void bind(MovieModel model){
           // Glide.with(itemView).load(model.getImageUri()).into();
        }
    }
}
