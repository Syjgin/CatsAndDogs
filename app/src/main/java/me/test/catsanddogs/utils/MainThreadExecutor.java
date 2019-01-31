package me.test.catsanddogs.utils;

public interface MainThreadExecutor {
    void executeInMainThread(Runnable operation);
}
