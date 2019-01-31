package me.test.catsanddogs.mvp.view.fragment.base;

import java.util.List;

import me.test.catsanddogs.mvp.model.ApiResponse;

public interface BaseListView {
    void displayData(List<ApiResponse.ImageDescription> response);
    void displayFetchError();
}
