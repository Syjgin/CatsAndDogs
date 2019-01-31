package me.test.catsanddogs.mvp.view.fragment.dog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import me.test.catsanddogs.application.AndroidApplication;
import me.test.catsanddogs.mvp.model.ApiResponse;
import me.test.catsanddogs.mvp.presenter.dog.DogPresenter;

public class DogFragment extends Fragment implements DogView {

    @Inject
    DogPresenter dogPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplication.getDogPresenterComponent().inject(this);
    }

    @Override
    public void displayData(ApiResponse response) {

    }

    @Override
    public void displayFetchError() {

    }
}
