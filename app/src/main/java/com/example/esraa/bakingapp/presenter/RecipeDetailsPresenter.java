package com.example.esraa.bakingapp.presenter;

import android.content.res.Configuration;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.esraa.bakingapp.R;
import com.example.esraa.bakingapp.fragment.StepVideoFragment;
import com.example.esraa.bakingapp.model.Steps;

public class RecipeDetailsPresenter extends BasePresenter implements IRecipeDetailsPresenter {
    private AppCompatActivity activity;

    public RecipeDetailsPresenter(AppCompatActivity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    public void navigateToStepDetails(Steps step) {
        if (isTablet()) {
            activity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.steps_video_frame_layout,  StepVideoFragment.newInstance(step.getVideoURL())).commit();
        } else {
            activity.getSupportFragmentManager().beginTransaction().addToBackStack(this.getClass().getSimpleName())
                    .replace(R.id.recipes_frame_layout,  StepVideoFragment.newInstance(step.getVideoURL())).commit();

        }
    }

}
