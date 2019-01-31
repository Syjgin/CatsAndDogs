package me.test.catsanddogs.mvp.presenter.cat;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CatPresenterModule {
    @Provides
    @Singleton
    CatPresenter provideCatPresenter() {
        return new CatPresenter();
    }
}
