package me.test.catsanddogs.mvp.view.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;

import javax.inject.Inject;

import me.test.catsanddogs.R;
import me.test.catsanddogs.constants.Constants;
import me.test.catsanddogs.di.Resolver;
import me.test.catsanddogs.mvp.model.ApiResponse;
import me.test.catsanddogs.mvp.presenter.main.MainPresenter;
import me.test.catsanddogs.mvp.view.activity.back.BackActivity;
import me.test.catsanddogs.mvp.view.activity.detail.DetailActivity;
import me.test.catsanddogs.mvp.view.fragment.cat.CatFragment;
import me.test.catsanddogs.mvp.view.fragment.dog.DogFragment;

public class MainActivity extends BackActivity implements MainView {

    private TabLayout tablayout;

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tablayout = findViewById(R.id.tabs);
        Resolver.getMainPresenterComponent().inject(this);
        presenter.onCreate(this);
    }

    @Override
    public void showTabName(int index, String name) {
        TabLayout.Tab tab = tablayout.getTabAt(index);
        if(tab != null) {
            tab.setText(name);
        }
    }

    @Override
    public void loadCatFragment() {
        CatFragment catFragment = new CatFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, catFragment);
        transaction.commit();
    }

    @Override
    public void loadDogFragment() {
        DogFragment catFragment = new DogFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, catFragment);
        transaction.commit();
    }

    @Override
    public void setupTabs() {
        tablayout.addTab(tablayout.newTab(), Constants.CatIndex);
        tablayout.addTab(tablayout.newTab(), Constants.DogIndex);
        tablayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                presenter.selectTab(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void setTabIndex(int index) {
        TabLayout.Tab tab = tablayout.getTabAt(index);
        if(tab != null && !tab.isSelected()) {
            tab.select();
        }
    }

    @Override
    public void displayDetailPage(ApiResponse.ImageDescription description) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.DetailKey, description);
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
