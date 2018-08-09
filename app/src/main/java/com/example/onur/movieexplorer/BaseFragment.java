package com.example.onur.movieexplorer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dagger.android.support.AndroidSupportInjection;

public abstract class BaseFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    public void showLoading(){
        getMainActivity().showLoading();
    }

    public void hideLoading(){
        getMainActivity().hideLoading();
    }

    protected MainActivity getMainActivity(){
        return (MainActivity) getActivity();
    }

    protected void navigateToFragment(BaseFragment fragment){
        getMainActivity().navigateToFragment(fragment);
    }

    @LayoutRes
    protected abstract int getLayoutId();
}
