package me.test.catsanddogs.interactor;

import javax.inject.Inject;

import me.test.catsanddogs.utils.MainThreadExecutor;

public abstract class BaseInteractor<Response> implements Interactor<Response> {

    @Inject
    MainThreadExecutor executor;

    void handleRepositoryResponse(Object repositoryResponse, final InteractorCallback<Response> interactorCallback) {
        if(repositoryResponse == null) {
            executor.executeInMainThread(new Runnable() {
                @Override
                public void run() {
                    interactorCallback.onFailure("empty response");
                }
            });
        } else {
            final Response finalResponse = (Response) repositoryResponse;
            executor.executeInMainThread(new Runnable() {
                @Override
                public void run() {
                    interactorCallback.onSuccess(finalResponse);
                }
            });
        }
    }
}
