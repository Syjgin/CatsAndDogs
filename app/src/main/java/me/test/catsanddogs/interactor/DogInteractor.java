package me.test.catsanddogs.interactor;

import me.test.catsanddogs.di.Resolver;
import me.test.catsanddogs.mvp.model.ApiResponse;
import me.test.catsanddogs.repository.DataRepositoryImplementation;

public class DogInteractor extends BaseInteractor<ApiResponse> {

    public DogInteractor() {
        Resolver.getMainThreadExecutorComponent().inject(this);
    }
    @Override
    public ApiResponse execute() {
        return new DataRepositoryImplementation().getDog();
    }
}
