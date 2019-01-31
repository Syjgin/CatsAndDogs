package me.test.catsanddogs.mvp.view.fragment.cat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import me.test.catsanddogs.application.AndroidApplication;
import me.test.catsanddogs.mvp.model.ApiResponse;
import me.test.catsanddogs.mvp.presenter.cat.CatPresenter;

public class CatFragment extends Fragment implements CatView {

    @Inject
    CatPresenter catPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplication.getCatPresenterComponent().inject(this);
    }

    @Override
    public void displayData(ApiResponse response) {

    }

    @Override
    public void displayFetchError() {

    }
}
