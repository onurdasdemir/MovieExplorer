package com.example.onur.movieexplorer.domain.interactor;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCase<Param, Response> {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    abstract Single<Response> buildUseCase(Param params);

    public void execute(Param param, Consumer<Response> success){
        compositeDisposable.add(buildUseCase(param)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(success, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) {

            }
        }));
    }


    public void dispose(){
        compositeDisposable.dispose();
    }
}
