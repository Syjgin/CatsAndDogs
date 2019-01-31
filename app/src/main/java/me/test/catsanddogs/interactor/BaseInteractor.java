package me.test.catsanddogs.interactor;

import android.os.Handler;
import android.os.Looper;

public abstract class BaseInteractor<Response> implements Interactor<Response> {

    private void executeInMainThread(Runnable operation) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(operation);
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
