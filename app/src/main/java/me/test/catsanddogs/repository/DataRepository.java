package me.test.catsanddogs.repository;

import me.test.catsanddogs.mvp.model.ApiResponse;

public interface DataRepository {
    ApiResponse getCat();
    ApiResponse getDog();
}
