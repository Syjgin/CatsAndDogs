package me.test.catsanddogs.application;

import android.app.Application;

import me.test.catsanddogs.services.ApiComponent;
import me.test.catsanddogs.services.ApiModule;
import me.test.catsanddogs.services.DaggerApiComponent;

public class AndroidApplication extends Application {
    private static ApiComponent apiComponent;

    public static ApiComponent getApiComponent() {
        return apiComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        apiComponent = DaggerApiComponent.builder().apiModule(new ApiModule()).build();
    }
}
