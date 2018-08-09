package com.example.onur.movieexplorer.util;

public class ObjectHelper {

    public static <T> T checkNotNull(T o){
        if (o == null) throw new IllegalArgumentException(o.getClass().getName() + ": can not be null");
        return o;
    }
}
