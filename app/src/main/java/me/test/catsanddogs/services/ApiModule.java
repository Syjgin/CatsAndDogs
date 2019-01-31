package me.test.catsanddogs.services;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.test.catsanddogs.constants.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
public class ApiModule {
    @Provides
    @Singleton
    ApiService provideApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BaseUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();
        return retrofit.create(ApiService.class);
    }
}
