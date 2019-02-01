package me.test.catsanddogs.utils;

import javax.inject.Singleton;

import dagger.Component;
import me.test.catsanddogs.interactor.CatInteractor;
import me.test.catsanddogs.interactor.DogInteractor;

@Singleton
@Component(modules = MainThreadExecutorModule.class)
public interface MainThreadExecutorComponent {
    void inject(CatInteractor interactor);
    void inject(DogInteractor interactor);
}
