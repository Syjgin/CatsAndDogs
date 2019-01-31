package me.test.catsanddogs.mvp.presenter.dog;

import javax.inject.Singleton;

import dagger.Component;
import me.test.catsanddogs.mvp.presenter.cat.CatPresenterModule;
import me.test.catsanddogs.mvp.view.fragment.cat.CatView;
import me.test.catsanddogs.mvp.view.fragment.dog.DogView;

@Singleton
@Component(modules = DogPresenterModule.class)
public interface DogPresenterComponent {
    void inject(DogView view);
}
