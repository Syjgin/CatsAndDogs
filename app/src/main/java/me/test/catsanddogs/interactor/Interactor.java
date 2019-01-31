package me.test.catsanddogs.interactor;

public interface Interactor<Response> {
    void execute(InteractorCallback<Response> callback);
}
