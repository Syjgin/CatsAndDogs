package me.test.catsanddogs.mvp.presenter.dog;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.test.catsanddogs.mvp.presenter.cat.CatPresenter;

@Module
public class DogPresenterModule {
    @Provides
    @Singleton
    DogPresenter provideCatPresenter() {
        return new DogPresenter();
    }
}
