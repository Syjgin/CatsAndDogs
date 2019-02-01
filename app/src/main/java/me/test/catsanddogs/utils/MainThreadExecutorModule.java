package me.test.catsanddogs.utils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainThreadExecutorModule {
    private final Boolean test;

    public MainThreadExecutorModule(Boolean test) {
        this.test = test;
    }

    @Provides
    @Singleton
    MainThreadExecutor provideMainThreadExecutor() {
        if(test) {
            return new MainThreadExecutorTestImplementation();
        }
        return new MainThreadExecutorImplementation();
    }
}
