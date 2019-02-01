package me.test.catsanddogs.application;

import android.app.Application;

import me.test.catsanddogs.di.Resolver;

public class AndroidApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Resolver resolver = new Resolver(false);
    }
}
