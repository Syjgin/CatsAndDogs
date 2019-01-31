package me.test.catsanddogs.mvp.view.fragment.cat;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import me.test.catsanddogs.R;
import me.test.catsanddogs.di.Resolver;
import me.test.catsanddogs.mvp.model.ApiResponse;
import me.test.catsanddogs.mvp.presenter.cat.CatPresenter;
import me.test.catsanddogs.mvp.view.adapter.ListAdapter;

public class CatFragment extends Fragment implements CatView {

    private ListAdapter listAdapter = new ListAdapter();

    @Inject
    CatPresenter catPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resolver.getCatPresenterComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(savedInstanceState == null) {
            RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            recyclerView.setAdapter(listAdapter);
            catPresenter.loadData(this);
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
