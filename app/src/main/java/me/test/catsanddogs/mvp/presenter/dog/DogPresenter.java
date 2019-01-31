package me.test.catsanddogs.mvp.presenter.dog;

import org.greenrobot.eventbus.EventBus;

import me.test.catsanddogs.constants.Constants;
import me.test.catsanddogs.interactor.DogInteractor;
import me.test.catsanddogs.interactor.InteractorCallback;
import me.test.catsanddogs.mvp.model.ApiResponse;
import me.test.catsanddogs.mvp.model.TabNameLoaded;
import me.test.catsanddogs.mvp.view.fragment.dog.DogView;

public class DogPresenter {

    private DogView view;

    public void loadData(final DogView view) {
        this.view = view;
        DogInteractor interactor = new DogInteractor();
        interactor.execute(new InteractorCallback<ApiResponse>() {
            @Override
            public void onSuccess(ApiResponse apiResponse) {
                view.displayData(apiResponse.data);
                EventBus.getDefault().post(new TabNameLoaded(apiResponse.message, Constants.DogIndex));
            }

            @Override
            public void onFailure(String errorMessage) {
                view.displayFetchError();
            }
        });
    }
}
