package me.test.catsanddogs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import me.test.catsanddogs.di.Resolver;
import me.test.catsanddogs.interactor.CatInteractor;
import me.test.catsanddogs.interactor.DogInteractor;
import me.test.catsanddogs.interactor.InteractorCallback;
import me.test.catsanddogs.mvp.model.ApiResponse;

public class RequestTest {
    private final CountDownLatch lock = new CountDownLatch(1);
    private ApiResponse response;

    @Before
    public void Prepare() {
        Resolver resolver = new Resolver(true);
    }

    @Test
    public void makeCatRequest() {
        CatInteractor interactor = new CatInteractor();
        interactor.execute(new InteractorCallback<ApiResponse>() {
            @Override
            public void onSuccess(ApiResponse apiResponse) {
                response = apiResponse;
                lock.countDown();
            }

            @Override
            public void onFailure(String errorMessage) {
                lock.countDown();
            }
        });
        try {
            lock.await(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(response);
    }

    @Test
    public void makeDogRequest() {
        DogInteractor interactor = new DogInteractor();
        interactor.execute(new InteractorCallback<ApiResponse>() {
            @Override
            public void onSuccess(ApiResponse apiResponse) {
                response = apiResponse;
                lock.countDown();
            }

            @Override
            public void onFailure(String errorMessage) {
                lock.countDown();
            }
        });
        try {
            lock.await(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(response);
    }
}