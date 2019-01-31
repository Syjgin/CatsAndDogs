package me.test.catsanddogs.mvp.presenter.main;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import me.test.catsanddogs.constants.Constants;
import me.test.catsanddogs.mvp.model.TabNameLoaded;
import me.test.catsanddogs.mvp.view.activity.MainView;

public class MainPresenter {

    private MainView view;
    private Integer selectedTab = Constants.CatIndex;

    public void onCreate(MainView view) {
        if(!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        this.view = view;
        view.setupTabs();
        view.setTabIndex(selectedTab);
        refreshFragments();
    }

    private void refreshFragments() {
        if(selectedTab.equals(Constants.CatIndex)) {
            view.loadCatFragment();
        } else if(selectedTab.equals(Constants.DogIndex)) {
            view.loadDogFragment();
        }
    }

    public void selectTab(int position) {
        if(position != selectedTab) {
            selectedTab = position;
            refreshFragments();
        }
    }

    public void onDestroy() {
        if(EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Subscribe
    public void onTabNameLoaded(TabNameLoaded event) {
        view.showTabName(event.tabIndex, event.tabName);
    }
}
