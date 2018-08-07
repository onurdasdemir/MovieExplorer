package com.example.onur.movieexplorer.di;

import android.app.Application;

import com.example.onur.movieexplorer.App;
import com.example.onur.movieexplorer.MainActivity;
import com.example.onur.movieexplorer.data.source.DataSourceModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Component(modules = {
        AndroidInjectionModule.class,
        DataSourceModule.class,
        MainActivityModule.class
})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    void inject(App app);
}
