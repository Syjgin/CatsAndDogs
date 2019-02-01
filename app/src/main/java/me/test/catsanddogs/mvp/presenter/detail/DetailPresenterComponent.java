package me.test.catsanddogs.mvp.presenter.detail;

import javax.inject.Singleton;

import dagger.Component;
import me.test.catsanddogs.mvp.view.activity.detail.DetailActivity;

@Singleton
@Component(modules = DetailPresenterModule.class)
public interface DetailPresenterComponent {
    void inject(DetailActivity activity);
}
