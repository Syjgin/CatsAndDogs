package me.test.catsanddogs.application;

import android.app.Application;

import me.test.catsanddogs.mvp.presenter.cat.CatPresenterComponent;
import me.test.catsanddogs.mvp.presenter.cat.CatPresenterModule;
import me.test.catsanddogs.mvp.presenter.cat.DaggerCatPresenterComponent;
import me.test.catsanddogs.mvp.presenter.dog.DaggerDogPresenterComponent;
import me.test.catsanddogs.mvp.presenter.dog.DogPresenterComponent;
import me.test.catsanddogs.mvp.presenter.dog.DogPresenterModule;
import me.test.catsanddogs.services.ApiComponent;
import me.test.catsanddogs.services.ApiModule;
import me.test.catsanddogs.services.DaggerApiComponent;

public class AndroidApplication extends Application {
    private static ApiComponent apiComponent;
    public static ApiComponent getApiComponent() {
        return apiComponent;
    }

    private static CatPresenterComponent catPresenterComponent;
    public static CatPresenterComponent getCatPresenterComponent() { return catPresenterComponent; }

    private static DogPresenterComponent dogPresenterComponent;
    public static DogPresenterComponent getDogPresenterComponent() { return dogPresenterComponent; }

    @Override
    public void onCreate() {
        super.onCreate();
        apiComponent = DaggerApiComponent.builder().apiModule(new ApiModule()).build();
        catPresenterComponent = DaggerCatPresenterComponent.builder().catPresenterModule(new CatPresenterModule()).build();
        dogPresenterComponent = DaggerDogPresenterComponent.builder().dogPresenterModule(new DogPresenterModule()).build();
    }
}
