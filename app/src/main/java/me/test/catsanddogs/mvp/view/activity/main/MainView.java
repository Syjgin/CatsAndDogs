package me.test.catsanddogs.mvp.view.activity.main;

import me.test.catsanddogs.mvp.model.ApiResponse;

public interface MainView {
    void showTabName(int index, String name);
    void loadCatFragment();
    void loadDogFragment();
    void setupTabs();
    void setTabIndex(int index);
    void displayDetailPage(ApiResponse.ImageDescription description);
}
