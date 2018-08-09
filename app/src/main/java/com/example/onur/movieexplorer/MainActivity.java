package com.example.onur.movieexplorer;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.onur.movieexplorer.presentation.movielist.MovieListFragment;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentAndroidInjector;
    private View viewLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewLoading = findViewById(R.id.viewLoading);
        if (savedInstanceState == null){
           navigateToFragment(new MovieListFragment());
        }
    }

    public void navigateToFragment(BaseFragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container,fragment)
                .addToBackStack(null)
                .commit();
    }

    public void showLoading(){
        viewLoading.setVisibility(View.VISIBLE);
    }

    public void hideLoading(){
        viewLoading.setVisibility(View.GONE);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return  fragmentAndroidInjector;
    }
}
