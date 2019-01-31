package me.test.catsanddogs.utils;

import android.os.Handler;
import android.os.Looper;

public class MainThreadExecutorTestImplementation implements MainThreadExecutor {
    @Override
    public void executeInMainThread(Runnable operation) {
        operation.run();
    }
}
