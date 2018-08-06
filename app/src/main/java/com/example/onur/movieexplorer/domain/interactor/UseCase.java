package com.example.onur.movieexplorer.domain.interactor;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public abstract class UseCase<Param, Response> {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    abstract Single<Response> buildUseCase(Param params);

    public void execute(Param param, Consumer<Response> success){
        compositeDisposable.add(buildUseCase(param).subscribe(success, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) {

            }
        }));
    }


    public void dispose(){
        compositeDisposable.dispose();
    }
}
