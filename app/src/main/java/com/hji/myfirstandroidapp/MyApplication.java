package com.hji.myfirstandroidapp;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by 현 on 2016-03-10.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initializeWithDefaults(this);
    }
}
