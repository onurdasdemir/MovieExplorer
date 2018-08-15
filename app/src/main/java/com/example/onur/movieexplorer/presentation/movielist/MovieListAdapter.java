package com.example.onur.movieexplorer.presentation.movielist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.onur.movieexplorer.R;
import com.example.onur.movieexplorer.domain.model.MovieModel;
import com.example.onur.movieexplorer.util.ObjectHelper;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieHolder> {

   private List<MovieModel> movieModelList;
   private OnMovieSelectedListener listener;

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
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null){
                    listener.onMovieSelected(movieModel.getId());
                }
            }
        });
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

    public void setOnMovieSelectedListener(OnMovieSelectedListener listener) {
        this.listener = listener;
    }

    static class MovieHolder extends RecyclerView.ViewHolder {
        ImageView posterImage = itemView.findViewById(R.id.poster_image);
        TextView textView = itemView.findViewById(R.id.movie_title);
        ProgressBar prgVote = itemView.findViewById(R.id.prgVote);
        TextView txtVote = itemView.findViewById(R.id.txtVote);
       MovieHolder(View itemView) {
            super(itemView);
        }

        void bind(MovieModel model){
            textView.setText(model.getName());
            txtVote.setText(String.valueOf(model.getRating()));
            prgVote.setProgress((int) model.getRating());
            Glide.with(itemView).load(model.getImageUri()).into(posterImage);
        }
    }

    interface OnMovieSelectedListener{
       void onMovieSelected(String movieId);
    }

}
