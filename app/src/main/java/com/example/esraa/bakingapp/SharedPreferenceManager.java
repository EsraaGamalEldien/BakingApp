package com.example.esraa.bakingapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreferenceManager {
    private static SharedPreferenceManager sharedPreferenceManager;
    protected Context context;
    private SharedPreferences.Editor editor;
    private SharedPreferences appSharedPrefs;

    private SharedPreferenceManager() {
        context = BakingApplicationClass.getContext();
        appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        editor = appSharedPrefs.edit();
    }

    public static SharedPreferenceManager getInstance() {
        if (sharedPreferenceManager == null)
            return new SharedPreferenceManager();
        return sharedPreferenceManager;
    }

    public void saveString(String key, String value) {
        editor.putString(key, value).commit();
    }

    public String getString(String key, String defaultValue) {
        return appSharedPrefs.getString(key, defaultValue);
    }

}
