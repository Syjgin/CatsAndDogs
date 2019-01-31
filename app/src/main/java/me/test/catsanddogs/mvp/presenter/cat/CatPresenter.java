package me.test.catsanddogs.mvp.presenter.cat;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import me.test.catsanddogs.constants.Constants;
import me.test.catsanddogs.interactor.CatInteractor;
import me.test.catsanddogs.interactor.InteractorCallback;
import me.test.catsanddogs.mvp.model.ApiResponse;
import me.test.catsanddogs.mvp.model.TabNameLoaded;
import me.test.catsanddogs.mvp.presenter.base.BaseListPresenter;
import me.test.catsanddogs.mvp.view.fragment.base.BaseListView;

public class CatPresenter implements BaseListPresenter {
    private BaseListView view;
    private int scrollPosition = 0;
    private List<ApiResponse.ImageDescription> cachedData;

    @Override
    public void loadData(final BaseListView view) {
        this.view = view;
        if(cachedData != null) {
            displayDataList(view);
        }
        CatInteractor interactor = new CatInteractor();
        interactor.execute(new InteractorCallback<ApiResponse>() {
            @Override
            public void onSuccess(ApiResponse apiResponse) {
                cachedData = apiResponse.data;
                displayDataList(view);
                EventBus.getDefault().post(new TabNameLoaded(apiResponse.message, Constants.CatIndex));
            }

            @Override
            public void onFailure(String errorMessage) {
                view.displayFetchError();
            }
        });
    }

    private void displayDataList(BaseListView view) {
        view.displayData(cachedData);
        view.setScrollPosition(scrollPosition);
    }

    @Override
    public void saveScrollPosition(int firstVisibleItemPosition) {
        if(firstVisibleItemPosition < 0)
            return;
        scrollPosition = firstVisibleItemPosition;
    }

}
