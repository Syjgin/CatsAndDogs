package me.test.catsanddogs.interactor;

import me.test.catsanddogs.mvp.model.ApiResponse;
import me.test.catsanddogs.repository.DataRepository;

public class DogInteractor extends BaseInteractor<ApiResponse> {

    public DogInteractor(DataRepository repository) {
        super(repository);
    }

    @Override
    public ApiResponse execute() {
        return repository.getCat();
    }
}
