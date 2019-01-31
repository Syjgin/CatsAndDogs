package me.test.catsanddogs.repository;

import me.test.catsanddogs.mvp.model.ApiResponse;

public interface DataRepository {
    interface RepositoryCallback {
        void onLoad(ApiResponse response);
    }
    void getCat(RepositoryCallback callback);
    void getDog(RepositoryCallback callback);
}
