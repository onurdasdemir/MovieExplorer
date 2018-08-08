package com.example.onur.movieexplorer.util;

public class ObjectHelper {

    @SuppressWarnings("unchecked")
    public static <T> T checkNotNull(Object o){
        if (o == null) throw new IllegalArgumentException(o.getClass().getName() + ": can not be null");
        return (T) o;
    }
}
