package me.test.catsanddogs.mvp.view.activity;

public interface MainView {
    void showTabName(Integer index, String name);
    void loadCatFragment();
    void loadDogFragment();
    void setupTabs();
    void setTabIndex(Integer index);
}
