package com.example.onur.movieexplorer.domain;

public interface Callback<R> {

    void onSuccess(R data);

    void onError(Throwable throwable);
}
