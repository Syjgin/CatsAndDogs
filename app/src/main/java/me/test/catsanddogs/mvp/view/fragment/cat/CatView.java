package me.test.catsanddogs.mvp.view.fragment.cat;

import java.util.List;

import me.test.catsanddogs.mvp.model.ApiResponse;

public interface CatView {
    void displayData(List<ApiResponse.ImageDescription> response);
    void displayFetchError();
}
