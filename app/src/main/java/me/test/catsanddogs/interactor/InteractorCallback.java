package me.test.catsanddogs.interactor;

public interface InteractorCallback<Response> {
    void onSuccess(Response response);
    void onFailure(String errorMessage);
}
