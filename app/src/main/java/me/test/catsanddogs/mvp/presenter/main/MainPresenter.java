package me.test.catsanddogs.mvp.presenter.main;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import me.test.catsanddogs.constants.Constants;
import me.test.catsanddogs.interactor.DogInteractor;
import me.test.catsanddogs.interactor.InteractorCallback;
import me.test.catsanddogs.mvp.model.ApiResponse;
import me.test.catsanddogs.mvp.model.TabNameLoaded;
import me.test.catsanddogs.mvp.view.activity.main.MainView;

public class MainPresenter {

    private MainView view;
    private int selectedTab = Constants.CatIndex;
    private String firstTabText;
    private String secondTabText;

    public void onCreate(final MainView view) {
        if(!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        this.view = view;
        view.setupTabs();
        view.setTabIndex(selectedTab);
        refreshFragments();
        if(firstTabText != null) {
            view.showTabName(Constants.CatIndex, firstTabText);
        }
        if(secondTabText == null) {
            DogInteractor interactor = new DogInteractor();
            interactor.execute(new InteractorCallback<ApiResponse>() {
                @Override
                public void onSuccess(ApiResponse apiResponse) {
                    secondTabText = apiResponse.message;
                    view.showTabName(Constants.DogIndex, secondTabText);
                }

                @Override
                public void onFailure(String errorMessage) {

                }
            });
        } else {
            view.showTabName(Constants.DogIndex, secondTabText);
        }
    }

    private void refreshFragments() {
        if(selectedTab == Constants.CatIndex) {
            view.loadCatFragment();
        } else if(selectedTab == Constants.DogIndex) {
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
        if(event.tabIndex == Constants.CatIndex) {
            firstTabText = event.tabName;
        }
        if(event.tabIndex == Constants.DogIndex) {
            secondTabText = event.tabName;
        }
        view.showTabName(event.tabIndex, event.tabName);
    }

    @Subscribe
    public void onListElementClicked(ApiResponse.ImageDescription event) {
        view.displayDetailPage(event);
    }
}
