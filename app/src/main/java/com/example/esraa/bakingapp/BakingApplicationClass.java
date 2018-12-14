package com.example.esraa.bakingapp;

import android.app.Application;
import android.content.Context;

public class BakingApplicationClass extends Application {
    private static Context context;
    @Override

    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static Context getContext() {
        return context;
    }
}
