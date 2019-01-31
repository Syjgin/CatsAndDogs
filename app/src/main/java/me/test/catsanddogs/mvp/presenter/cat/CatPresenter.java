package me.test.catsanddogs.mvp.presenter.cat;

import org.greenrobot.eventbus.EventBus;

import me.test.catsanddogs.constants.Constants;
import me.test.catsanddogs.interactor.CatInteractor;
import me.test.catsanddogs.interactor.InteractorCallback;
import me.test.catsanddogs.mvp.model.ApiResponse;
import me.test.catsanddogs.mvp.model.TabNameLoaded;
import me.test.catsanddogs.mvp.view.fragment.cat.CatView;

public class CatPresenter {
    private CatView view;

    public void loadData(final CatView view) {
        this.view = view;
        CatInteractor interactor = new CatInteractor();
        interactor.execute(new InteractorCallback<ApiResponse>() {
            @Override
            public void onSuccess(ApiResponse apiResponse) {
                view.displayData(apiResponse.data);
                EventBus.getDefault().post(new TabNameLoaded(apiResponse.message, Constants.CatIndex));
            }

            @Override
            public void onFailure(String errorMessage) {
                view.displayFetchError();
            }
        });
    }
}
