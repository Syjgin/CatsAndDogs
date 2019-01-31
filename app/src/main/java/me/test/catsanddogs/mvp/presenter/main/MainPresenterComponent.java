package me.test.catsanddogs.mvp.presenter.main;

import javax.inject.Singleton;

import dagger.Component;
import me.test.catsanddogs.mvp.view.activity.main.MainActivity;

@Singleton
@Component(modules = MainPresenterModule.class)
public interface MainPresenterComponent {
    void inject(MainActivity activity);
}
