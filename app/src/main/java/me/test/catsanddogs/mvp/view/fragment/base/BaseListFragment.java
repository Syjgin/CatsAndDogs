package me.test.catsanddogs.mvp.view.fragment.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.test.catsanddogs.R;
import me.test.catsanddogs.mvp.presenter.base.BaseListPresenter;
import me.test.catsanddogs.mvp.view.adapter.ListAdapter;

public abstract class BaseListFragment extends Fragment implements BaseListView {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_fragment, container, false);
    }

    protected void setupAdapter(
            View view,
            ListAdapter adapter,
            BaseListPresenter presenter) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        presenter.loadData(this);
    }
}
