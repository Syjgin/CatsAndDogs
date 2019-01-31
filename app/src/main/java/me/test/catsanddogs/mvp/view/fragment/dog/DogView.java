package me.test.catsanddogs.mvp.view.fragment.dog;

import me.test.catsanddogs.mvp.model.ApiResponse;

public interface DogView {
    void displayData(ApiResponse response);
    void displayFetchError();
}
