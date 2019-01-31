package me.test.catsanddogs.repository;

import me.test.catsanddogs.mvp.model.ApiResponse;
import retrofit2.Response;

public interface DataRepository {
    ApiResponse getCat();
    ApiResponse getDog();
}
