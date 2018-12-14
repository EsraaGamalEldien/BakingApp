package com.example.esraa.bakingapp.activity;

import android.os.Bundle;

import com.example.esraa.bakingapp.R;
import com.example.esraa.bakingapp.presenter.IMainPresenter;
import com.example.esraa.bakingapp.presenter.MainPresenter;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            IMainPresenter mainPresenter = new MainPresenter(this);
            mainPresenter.inflateToReceiptsFragment(this);
        }
    }

}
