package com.wumeijie.volleymanager.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by cyyang on 16/10/9.
 */

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext(){
        return context;
    }
}
