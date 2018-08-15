package com.example.onur.movieexplorer.presentation.movielist;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.onur.movieexplorer.BaseFragment;
import com.example.onur.movieexplorer.R;
import com.example.onur.movieexplorer.domain.model.MovieModel;
import com.example.onur.movieexplorer.presentation.moviedetail.MovieDetailFragment;

import java.util.List;

import javax.inject.Inject;


public class MovieListFragment extends BaseFragment implements MovieListContract.View {

    @Inject MovieListContract.Presenter presenter;
    @Inject MovieListAdapter adapter;
    private RecyclerView rvMovies;

    public MovieListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMovies = view.findViewById(R.id.rvMovies);
        rvMovies.setAdapter(adapter);
        adapter.setOnMovieSelectedListener(new MovieListAdapter.OnMovieSelectedListener() {
            @Override
            public void onMovieSelected(String movieId) {
                presenter.onMovieSelected(movieId);
            }
        });
        presenter.takeView(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.getUpComingMovies();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.dropView();
    }

    @Override
    public void renderUpcomingMovies(List<MovieModel> movieModels) {
        adapter.setMovieModelList(movieModels);
    }

    @Override
    public void navigateToDetails(String movieId) {
        navigateToFragment(MovieDetailFragment.newInstance(movieId));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_movie_list;
    }
}
