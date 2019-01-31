package me.test.catsanddogs.mvp.view.fragment.dog;

import java.util.List;

import me.test.catsanddogs.mvp.model.ApiResponse;

public interface DogView {
    void displayData(List<ApiResponse.ImageDescription> response);
    void displayFetchError();
}
