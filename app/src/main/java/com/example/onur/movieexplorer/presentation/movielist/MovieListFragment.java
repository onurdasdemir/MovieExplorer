package com.example.onur.movieexplorer.presentation.movielist;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onur.movieexplorer.BaseFragment;
import com.example.onur.movieexplorer.R;
import com.example.onur.movieexplorer.data.entity.MovieEntity;
import com.example.onur.movieexplorer.domain.mapper.MovieMapper;
import com.example.onur.movieexplorer.domain.model.MovieModel;

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
    protected int getLayoutId() {
        return R.layout.fragment_movie_list;
    }
}
