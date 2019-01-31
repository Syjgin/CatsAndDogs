package me.test.catsanddogs.utils;

public class MainThreadExecutorTestImplementation implements MainThreadExecutor {
    @Override
    public void executeInMainThread(Runnable operation) {
        operation.run();
    }
}
