package me.test.catsanddogs.interactor;

import me.test.catsanddogs.mvp.model.ApiResponse;
import me.test.catsanddogs.repository.DataRepository;

public class CatInteractor extends BaseInteractor<ApiResponse> {

    public CatInteractor(DataRepository repository) {
        super(repository);
    }

    @Override
    public ApiResponse execute() {
        return repository.getCat();
    }
}
