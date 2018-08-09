package com.example.onur.movieexplorer.presentation.moviedetail;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.onur.movieexplorer.BaseFragment;
import com.example.onur.movieexplorer.R;
import com.example.onur.movieexplorer.data.entity.MovieDetailEntity;
import com.example.onur.movieexplorer.util.ObjectHelper;

import java.util.Objects;

import javax.inject.Inject;

public class MovieDetailFragment extends BaseFragment implements MovieDetailContract.View {

    private static final String ARG_MOVIE_ID = "movie_id";

    public static MovieDetailFragment newInstance(String movieId) {
        Bundle args = new Bundle();
        args.putString(ARG_MOVIE_ID, movieId);
        MovieDetailFragment fragment = new MovieDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Inject
    MovieDetailContract.Presenter presenter;


    public MovieDetailFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_movie_detail;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.takeView(this);
        String movieId = ObjectHelper.checkNotNull(getArguments()).getString(ARG_MOVIE_ID);
        presenter.getMovieDetails(movieId);
    }

    @Override
    public void onDestroyView() {
        presenter.dropView();
        super.onDestroyView();
    }

    @Override
    public void renderMovieDetails(MovieDetailEntity movieDetailEntity) {
        Toast.makeText(getContext(), movieDetailEntity.id, Toast.LENGTH_LONG).show();
    }
}
