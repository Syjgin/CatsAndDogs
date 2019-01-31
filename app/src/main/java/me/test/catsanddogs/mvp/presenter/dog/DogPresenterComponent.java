package me.test.catsanddogs.mvp.presenter.dog;

import javax.inject.Singleton;

import dagger.Component;
import me.test.catsanddogs.mvp.view.fragment.dog.DogFragment;

@Singleton
@Component(modules = DogPresenterModule.class)
public interface DogPresenterComponent {
    void inject(DogFragment fragment);
}
