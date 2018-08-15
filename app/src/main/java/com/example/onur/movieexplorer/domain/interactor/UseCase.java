package com.example.onur.movieexplorer.domain.interactor;

import android.support.annotation.NonNull;

import com.example.onur.movieexplorer.domain.Callback;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCase<Param, Response> {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    abstract Single<Response> buildUseCase(Param params);

    public void execute(Param param, @NonNull final Callback<Response> callback){
        compositeDisposable.add(buildUseCase(param)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response>() {
                    @Override
                    public void accept(Response response) {
                        callback.onSuccess(response);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        callback.onError(throwable);
                    }
                }));
    }


    public void dispose(){
        compositeDisposable.clear();
    }
}
