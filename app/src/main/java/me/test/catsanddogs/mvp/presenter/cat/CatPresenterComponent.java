package me.test.catsanddogs.mvp.presenter.cat;

import javax.inject.Singleton;

import dagger.Component;
import me.test.catsanddogs.mvp.view.fragment.cat.CatFragment;

@Singleton
@Component(modules = CatPresenterModule.class)
public interface CatPresenterComponent {
    void inject(CatFragment fragment);
}
