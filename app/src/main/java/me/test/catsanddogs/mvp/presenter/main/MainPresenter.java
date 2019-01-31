package me.test.catsanddogs.mvp.presenter.main;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import me.test.catsanddogs.constants.Constants;
import me.test.catsanddogs.interactor.DogInteractor;
import me.test.catsanddogs.interactor.InteractorCallback;
import me.test.catsanddogs.mvp.model.ApiResponse;
import me.test.catsanddogs.mvp.model.TabNameLoaded;
import me.test.catsanddogs.mvp.view.activity.MainView;

public class MainPresenter {

    private MainView view;
    private Integer selectedTab = Constants.CatIndex;
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
        if(event.tabIndex.equals(Constants.CatIndex)) {
            firstTabText = event.tabName;
        }
        if(event.tabIndex.equals(Constants.DogIndex)) {
            secondTabText = event.tabName;
        }
        view.showTabName(event.tabIndex, event.tabName);
    }
}
