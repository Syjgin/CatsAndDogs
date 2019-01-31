package me.test.catsanddogs.mvp.view.fragment.dog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import me.test.catsanddogs.di.Resolver;
import me.test.catsanddogs.mvp.model.ApiResponse;
import me.test.catsanddogs.mvp.presenter.dog.DogPresenter;
import me.test.catsanddogs.mvp.view.adapter.ListAdapter;
import me.test.catsanddogs.mvp.view.fragment.base.BaseListFragment;
import me.test.catsanddogs.mvp.view.fragment.base.BaseListView;

public class DogFragment extends BaseListFragment implements BaseListView {

    private ListAdapter listAdapter = new ListAdapter();


    @Inject
    DogPresenter dogPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resolver.getDogPresenterComponent().inject(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(savedInstanceState == null) {
            setupAdapter(view, listAdapter, dogPresenter);
        }
    }

    @Override
    public void displayData(List<ApiResponse.ImageDescription> response) {
        listAdapter.displayData(response);
    }

    @Override
    public void displayFetchError() {

    }
}
