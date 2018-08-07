package com.example.onur.movieexplorer.presentation.movielist;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onur.movieexplorer.BaseFragment;
import com.example.onur.movieexplorer.R;
import com.example.onur.movieexplorer.domain.model.MovieModel;

import java.util.List;

import javax.inject.Inject;


public class MovieListFragment extends BaseFragment implements MovieListContract.View {

    @Inject MovieListContract.Presenter presenter;
    private TextView textView;

    public MovieListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.text);
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
        textView.setText(movieModels.toString());
    }
}
