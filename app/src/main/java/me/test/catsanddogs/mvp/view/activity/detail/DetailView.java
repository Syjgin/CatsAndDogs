package me.test.catsanddogs.mvp.view.activity.detail;

import me.test.catsanddogs.mvp.model.ApiResponse;

public interface DetailView {
    void displayData(ApiResponse.ImageDescription description);
}
