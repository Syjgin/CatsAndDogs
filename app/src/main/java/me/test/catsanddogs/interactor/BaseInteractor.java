package me.test.catsanddogs.interactor;

import javax.inject.Inject;

import me.test.catsanddogs.utils.MainThreadExecutor;

public abstract class BaseInteractor<Response> implements Interactor<Response> {

    @Inject
    public MainThreadExecutor executor;

    public void executeRequest(final InteractorCallback<Response> callback) {
        Response response = null;
        try {
            response = execute();
        } catch (final Exception e) {
            e.printStackTrace();
            executor.executeInMainThread(new Runnable() {
                @Override
                public void run() {
                    callback.onFailure(e.getMessage());
                }
            });
        }
        if(response != null) {
            final Response finalResponse = response;
            executor.executeInMainThread(new Runnable() {
                @Override
                public void run() {
                    callback.onSuccess(finalResponse);
                }
            });
        } else {
            executor.executeInMainThread(new Runnable() {
                @Override
                public void run() {
                    callback.onFailure("empty response");
                }
            });
        }
    }
}
