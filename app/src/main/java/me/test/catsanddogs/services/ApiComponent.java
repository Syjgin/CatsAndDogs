package me.test.catsanddogs.services;

import javax.inject.Singleton;

import dagger.Component;
import me.test.catsanddogs.repository.DataRepositoryImplementation;

@Singleton
@Component(modules = ApiModule.class)
public interface ApiComponent {
    void inject(DataRepositoryImplementation implementation);
}
