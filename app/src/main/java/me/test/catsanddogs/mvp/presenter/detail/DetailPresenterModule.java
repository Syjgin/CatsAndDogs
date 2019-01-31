package me.test.catsanddogs.mvp.presenter.detail;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailPresenterModule {
    @Provides
    @Singleton
    DetailPresenter provideDetailPresenter() {
        return new DetailPresenter();
    }
}
