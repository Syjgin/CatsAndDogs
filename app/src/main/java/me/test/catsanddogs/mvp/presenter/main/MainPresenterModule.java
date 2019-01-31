package me.test.catsanddogs.mvp.presenter.main;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainPresenterModule {
    @Provides
    @Singleton
    MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }
}
