package me.test.catsanddogs.mvp.view.activity;

public interface MainView {
    void showTabName(int index, String name);
    void loadCatFragment();
    void loadDogFragment();
    void setupTabs();
    void setTabIndex(int index);
}
