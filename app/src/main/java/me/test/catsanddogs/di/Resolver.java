package me.test.catsanddogs.di;

import me.test.catsanddogs.mvp.presenter.cat.CatPresenterComponent;
import me.test.catsanddogs.mvp.presenter.cat.CatPresenterModule;
import me.test.catsanddogs.mvp.presenter.cat.DaggerCatPresenterComponent;
import me.test.catsanddogs.mvp.presenter.detail.DaggerDetailPresenterComponent;
import me.test.catsanddogs.mvp.presenter.detail.DetailPresenterComponent;
import me.test.catsanddogs.mvp.presenter.detail.DetailPresenterModule;
import me.test.catsanddogs.mvp.presenter.dog.DaggerDogPresenterComponent;
import me.test.catsanddogs.mvp.presenter.dog.DogPresenterComponent;
import me.test.catsanddogs.mvp.presenter.dog.DogPresenterModule;
import me.test.catsanddogs.mvp.presenter.main.DaggerMainPresenterComponent;
import me.test.catsanddogs.mvp.presenter.main.MainPresenterComponent;
import me.test.catsanddogs.mvp.presenter.main.MainPresenterModule;
import me.test.catsanddogs.services.ApiComponent;
import me.test.catsanddogs.services.ApiModule;
import me.test.catsanddogs.services.DaggerApiComponent;
import me.test.catsanddogs.utils.DaggerMainThreadExecutorComponent;
import me.test.catsanddogs.utils.MainThreadExecutorComponent;
import me.test.catsanddogs.utils.MainThreadExecutorModule;

public class Resolver {
    private static ApiComponent apiComponent;
    public static ApiComponent getApiComponent() {
        return apiComponent;
    }

    private static CatPresenterComponent catPresenterComponent;
    public static CatPresenterComponent getCatPresenterComponent() { return catPresenterComponent; }

    private static DogPresenterComponent dogPresenterComponent;
    public static DogPresenterComponent getDogPresenterComponent() { return dogPresenterComponent; }

    private static MainThreadExecutorComponent mainThreadExecutorComponent;
    public static MainThreadExecutorComponent getMainThreadExecutorComponent() { return mainThreadExecutorComponent; }

    private static MainPresenterComponent mainPresenterComponent;
    public static MainPresenterComponent getMainPresenterComponent() { return mainPresenterComponent; }

    private static DetailPresenterComponent detailPresenterComponent;
    public static DetailPresenterComponent getDetailPresenterComponent() { return detailPresenterComponent; }

    public Resolver(Boolean test) {
        apiComponent = DaggerApiComponent.builder().apiModule(new ApiModule()).build();
        catPresenterComponent = DaggerCatPresenterComponent.builder().catPresenterModule(new CatPresenterModule()).build();
        dogPresenterComponent = DaggerDogPresenterComponent.builder().dogPresenterModule(new DogPresenterModule()).build();
        mainThreadExecutorComponent = DaggerMainThreadExecutorComponent.builder().mainThreadExecutorModule(new MainThreadExecutorModule(test)).build();
        mainPresenterComponent = DaggerMainPresenterComponent.builder().mainPresenterModule(new MainPresenterModule()).build();
        detailPresenterComponent = DaggerDetailPresenterComponent.builder().detailPresenterModule(new DetailPresenterModule()).build();
    }
}
