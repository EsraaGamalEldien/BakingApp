package com.example.esraa.bakingapp.presenter;

import android.app.Activity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.esraa.bakingapp.R;
import com.example.esraa.bakingapp.fragment.RecipesFragment;

public class MainPresenter extends BasePresenter  implements IMainPresenter {

    public MainPresenter(Activity activity) {
        super(activity);
    }

    @Override
    public void inflateToReceiptsFragment(AppCompatActivity activity) {
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.screen_frame_layout,  new RecipesFragment()).commit();
    }
}
