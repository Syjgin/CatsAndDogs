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
import android.widget.Toast;

import java.util.List;

import me.test.catsanddogs.R;
import me.test.catsanddogs.mvp.model.ApiResponse;
import me.test.catsanddogs.mvp.presenter.base.BaseListPresenter;
import me.test.catsanddogs.mvp.view.adapter.ListAdapter;

public abstract class BaseListFragment extends Fragment implements BaseListView {

    protected RecyclerView recyclerView;
    protected ListAdapter listAdapter = new ListAdapter();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_fragment, container, false);
    }

    protected void setupAdapter(
            View view,
            final BaseListPresenter presenter) {
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(listAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager)recyclerView.getLayoutManager();
                if(layoutManager != null)
                    presenter.saveScrollPosition(layoutManager.findFirstCompletelyVisibleItemPosition());
            }
        });
        presenter.loadData(this);
    }

    @Override
    public void displayData(List<ApiResponse.ImageDescription> response) {
        listAdapter.displayData(response);
    }

    public void setScrollPosition(int scrollPosition) {
        if(recyclerView != null) {
            recyclerView.scrollToPosition(scrollPosition);
        }
    }

    @Override
    public void displayFetchError() {
        Toast.makeText(getContext(), getString(R.string.fetch_error), Toast.LENGTH_LONG).show();
    }
}
