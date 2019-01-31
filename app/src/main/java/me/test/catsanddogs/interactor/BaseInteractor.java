package me.test.catsanddogs.interactor;

import android.os.Handler;
import android.os.Looper;

import me.test.catsanddogs.repository.DataRepository;

public abstract class BaseInteractor<Response> implements Interactor<Response> {
    protected DataRepository repository;
    private void executeInMainThread(Runnable operation) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(operation);
    }

    public BaseInteractor(DataRepository repository) {
        this.repository = repository;
    }

    public void executeRequest(final InteractorCallback<Response> callback) {
        Response response = null;
        try {
            response = execute();
        } catch (final Exception e) {
            e.printStackTrace();
            executeInMainThread(new Runnable() {
                @Override
                public void run() {
                    callback.onFailure(e.getMessage());
                }
            });
        }
        if(response != null) {
            final Response finalResponse = response;
            executeInMainThread(new Runnable() {
                @Override
                public void run() {
                    callback.onSuccess(finalResponse);
                }
            });
        } else {
            executeInMainThread(new Runnable() {
                @Override
                public void run() {
                    callback.onFailure("empty response");
                }
            });
        }
    }
}
