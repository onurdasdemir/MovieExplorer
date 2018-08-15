package com.example.onur.movieexplorer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
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

    public void showError(String content){
        new AlertDialog.Builder(getMainActivity()).setTitle(getString(R.string.error_title))
                .setMessage(TextUtils.isEmpty(content) ? getString(R.string.default_error) : content)
                .setPositiveButton(getString(R.string.ok), null)
                .create()
                .show();
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
