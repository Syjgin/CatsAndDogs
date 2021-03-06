package me.test.catsanddogs.mvp.presenter.base;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import me.test.catsanddogs.interactor.BaseInteractor;
import me.test.catsanddogs.interactor.InteractorCallback;
import me.test.catsanddogs.mvp.model.ApiResponse;
import me.test.catsanddogs.mvp.model.TabNameLoaded;
import me.test.catsanddogs.mvp.view.fragment.base.BaseListView;

public abstract class BaseListPresenterImplementation implements BaseListPresenter {
    private int scrollPosition = 0;
    private List<ApiResponse.ImageDescription> cachedData;

    protected abstract BaseInteractor getInteractor();
    protected abstract int getIndex();

    @Override
    public void loadData(final BaseListView view) {
        if(cachedData != null) {
            displayDataList(view);
        }
        BaseInteractor interactor = getInteractor();
        interactor.execute(new InteractorCallback<ApiResponse>() {
            @Override
            public void onSuccess(ApiResponse apiResponse) {
                cachedData = apiResponse.data;
                displayDataList(view);
                EventBus.getDefault().post(new TabNameLoaded(apiResponse.message, getIndex()));
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
