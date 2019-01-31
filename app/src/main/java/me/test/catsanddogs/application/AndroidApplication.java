package me.test.catsanddogs.application;

import android.app.Application;

import me.test.catsanddogs.di.Resolver;

public class AndroidApplication extends Application {

    private static Resolver resolver;
    public static Resolver getResolver() { return resolver; }

    @Override
    public void onCreate() {
        super.onCreate();
        resolver = new Resolver(false);
    }
}
