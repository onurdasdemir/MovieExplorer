package com.example.onur.movieexplorer.presentation.moviedetail;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.onur.movieexplorer.BaseFragment;
import com.example.onur.movieexplorer.R;
import com.example.onur.movieexplorer.domain.model.MovieDetailModel;
import com.example.onur.movieexplorer.util.ObjectHelper;

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

    private ImageView imgPoster;
    private TextView txtOriginalTitle;
    private TextView txtOverView;
    private TextView txtRuntime;
    private TextView txtReleaseDate;

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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imgPoster = view.findViewById(R.id.imgPoster);
        txtOriginalTitle = view.findViewById(R.id.txtOriginalTitle);
        txtOverView = view.findViewById(R.id.txtOverview);
        txtRuntime = view.findViewById(R.id.txtRunTime);
        txtReleaseDate = view.findViewById(R.id.txtReleaseDate);

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
    public void renderMovieDetails(MovieDetailModel movieDetailModel) {
        Glide.with(this).load(movieDetailModel.getImageUri()).into(imgPoster);
        txtReleaseDate.setText(movieDetailModel.getReleaseDate());
        txtRuntime.setText(movieDetailModel.getRunTime());
        txtOverView.setText(movieDetailModel.getOverView());
        txtOriginalTitle.setText(movieDetailModel.getOriginalTitle());
    }
}
