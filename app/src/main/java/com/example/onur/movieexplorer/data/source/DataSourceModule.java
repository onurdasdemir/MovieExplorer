package com.example.onur.movieexplorer.data.source;

import com.example.onur.movieexplorer.data.source.local.MovieLocalDataSource;
import com.example.onur.movieexplorer.data.source.remote.MovieRemoteDataSource;
import com.example.onur.movieexplorer.data.source.remote.network.MovieService;

import java.util.concurrent.TimeUnit;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public abstract class DataSourceModule {

    @Provides
    static OkHttpClient provideOkHttpClient(){
        return new OkHttpClient.Builder()
                .readTimeout(3, TimeUnit.MINUTES)
                .writeTimeout(3, TimeUnit.MINUTES)
                .build();
    }

    @Provides
    static Retrofit provideRetrofit(OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3")
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    static MovieService provideMovieService(Retrofit retrofit){
        return retrofit.create(MovieService.class);
    }

    @Local
    @Binds
    abstract MovieDataSource bindMovieLocalDataSource(MovieLocalDataSource movieLocalDataSource);

    @Remote
    @Binds
    abstract MovieDataSource bindMovieRemoteDataSource(MovieRemoteDataSource movieLocalDataSource);

    @Binds
    abstract MovieDataSource bindRepository(MovieRepository repository);
}
