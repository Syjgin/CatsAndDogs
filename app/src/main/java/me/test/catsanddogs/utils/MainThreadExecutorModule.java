package me.test.catsanddogs.utils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.test.catsanddogs.constants.Constants;
import me.test.catsanddogs.services.ApiService;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

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
