package me.test.catsanddogs.mvp.view.fragment.cat;

import me.test.catsanddogs.mvp.model.ApiResponse;

public interface CatView {
    void displayData(ApiResponse response);
    void displayFetchError();
}
