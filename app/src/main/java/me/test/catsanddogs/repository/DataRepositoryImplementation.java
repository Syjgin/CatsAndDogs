package me.test.catsanddogs.repository;

import me.test.catsanddogs.constants.Constants;
import me.test.catsanddogs.mvp.model.ApiResponse;
import me.test.catsanddogs.services.ApiImplementation;

public class DataRepositoryImplementation implements DataRepository {
    @Override
    public ApiResponse getCat() {
        try {
            return ApiImplementation.getInstance().getResponse(Constants.Cat).execute().body();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ApiResponse getDog() {
        try {
            return ApiImplementation.getInstance().getResponse(Constants.Dog).execute().body();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
