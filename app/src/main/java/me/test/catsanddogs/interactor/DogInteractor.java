package me.test.catsanddogs.interactor;

import me.test.catsanddogs.mvp.model.ApiResponse;
import me.test.catsanddogs.repository.DataRepositoryImplementation;

public class DogInteractor extends BaseInteractor<ApiResponse> {

    @Override
    public ApiResponse execute() {
        return new DataRepositoryImplementation().getDog();
    }
}
