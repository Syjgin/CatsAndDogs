package me.test.catsanddogs.mvp.view.activity.detail;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import me.test.catsanddogs.R;
import me.test.catsanddogs.di.Resolver;
import me.test.catsanddogs.mvp.model.ApiResponse;
import me.test.catsanddogs.mvp.presenter.detail.DetailPresenter;
import me.test.catsanddogs.mvp.view.activity.back.BackActivity;

public class DetailActivity extends BackActivity implements DetailView {

    @Inject
    DetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Resolver.getDetailPresenterComponent().inject(this);
        presenter.onCreate(this, getIntent().getExtras());
    }

    @Override
    public void displayData(ApiResponse.ImageDescription description) {
        Picasso.get().load(description.url).into((ImageView) findViewById(R.id.picture));
        ((TextView)findViewById(R.id.title)).setText(description.title);
    }
}
