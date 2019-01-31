package me.test.catsanddogs.interactor;

import me.test.catsanddogs.mvp.model.ApiResponse;
import me.test.catsanddogs.repository.DataRepositoryImplementation;

public class CatInteractor extends BaseInteractor<ApiResponse> {

    @Override
    public ApiResponse execute() {
        return new DataRepositoryImplementation().getCat();
    }
}
