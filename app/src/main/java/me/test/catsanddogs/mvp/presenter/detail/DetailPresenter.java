package me.test.catsanddogs.mvp.presenter.detail;

import android.os.Bundle;

import me.test.catsanddogs.constants.Constants;
import me.test.catsanddogs.mvp.model.ApiResponse;
import me.test.catsanddogs.mvp.view.activity.detail.DetailView;

public class DetailPresenter {

    public void onCreate(final DetailView detailView, Bundle bundle) {
        ApiResponse.ImageDescription description = (ApiResponse.ImageDescription) bundle.getSerializable(Constants.DetailKey);
        if(description != null)
            detailView.displayData(description);
    }
}
