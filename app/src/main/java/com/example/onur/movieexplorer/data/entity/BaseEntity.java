package com.example.onur.movieexplorer.data.entity;

import java.util.concurrent.TimeUnit;

public class BaseEntity {

    private long createdTime = now();
    protected boolean empty = false;

    public boolean isFresh(TimeUnit timeUnit, int expireTime){
       return !empty && (createdTime + timeUnit.toMillis(expireTime) > now());
    }

    private long now(){
        return System.currentTimeMillis();
    }
}
