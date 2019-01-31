package me.test.catsanddogs.repository;

import javax.inject.Inject;

import me.test.catsanddogs.constants.Constants;
import me.test.catsanddogs.di.Resolver;
import me.test.catsanddogs.mvp.model.ApiResponse;
import me.test.catsanddogs.services.ApiService;

public class DataRepositoryImplementation implements DataRepository {

    @Inject
    ApiService service;

    public DataRepositoryImplementation () {
        Resolver.getApiComponent().inject(this);
    }

    @Override
    public ApiResponse getCat() {
        try {
            return service.getResponse(Constants.Cat).execute().body();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ApiResponse getDog() {
        try {
            return service.getResponse(Constants.Dog).execute().body();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
