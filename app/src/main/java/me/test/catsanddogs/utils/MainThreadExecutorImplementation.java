package me.test.catsanddogs.utils;

import android.os.Handler;
import android.os.Looper;

public class MainThreadExecutorImplementation implements MainThreadExecutor {
    @Override
    public void executeInMainThread(Runnable operation) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(operation);
    }
}
