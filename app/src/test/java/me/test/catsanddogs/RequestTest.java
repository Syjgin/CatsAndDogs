package me.test.catsanddogs;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import me.test.catsanddogs.application.AndroidApplication;
import me.test.catsanddogs.interactor.CatInteractor;
import me.test.catsanddogs.interactor.DogInteractor;
import me.test.catsanddogs.interactor.InteractorCallback;
import me.test.catsanddogs.mvp.model.ApiResponse;
import me.test.catsanddogs.repository.DataRepositoryImplementation;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@Config(application = AndroidApplication.class, sdk = 23)
public class RequestTest {
    private CountDownLatch lock = new CountDownLatch(1);
    private ApiResponse response;
    @Test
    public void makeCatRequest() {
        CatInteractor interactor = new CatInteractor(new DataRepositoryImplementation());
        interactor.executeRequest(new InteractorCallback<ApiResponse>() {
            @Override
            public void onSuccess(ApiResponse apiResponse) {
                response = apiResponse;
                lock.countDown();
            }

            @Override
            public void onFailure(String errorMessage) {
                Assert.fail(errorMessage);
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
        DogInteractor interactor = new DogInteractor(new DataRepositoryImplementation());
        interactor.executeRequest(new InteractorCallback<ApiResponse>() {
            @Override
            public void onSuccess(ApiResponse apiResponse) {
                response = apiResponse;
                lock.countDown();
            }

            @Override
            public void onFailure(String errorMessage) {
                Assert.fail(errorMessage);
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