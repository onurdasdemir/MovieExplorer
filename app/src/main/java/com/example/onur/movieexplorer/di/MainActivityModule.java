package com.example.onur.movieexplorer.di;


import com.example.onur.movieexplorer.MainActivity;
import com.example.onur.movieexplorer.presentation.FragmentBuildersModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class MainActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MainActivity contributeMainActivity();
}
