package com.example.esraa.bakingapp.presenter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Configuration;

import com.example.esraa.bakingapp.R;

public class BasePresenter implements IBasePresenter {
    protected ProgressDialog progressDialog;
    private Activity activity;

    BasePresenter(Activity activity) {
        this.activity = activity;
        initProgressDialog();
    }

    private void initProgressDialog() {
        progressDialog = new ProgressDialog(activity);
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(activity.getString(R.string.dialog_loading_message));
        progressDialog.setMax(100);
    }

    public boolean isTablet() {
        return (activity.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }
}
