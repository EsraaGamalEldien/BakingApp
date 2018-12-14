package com.example.esraa.bakingapp.activity;

import android.os.Bundle;

import com.example.esraa.bakingapp.R;
import com.example.esraa.bakingapp.fragment.RecipeDetailsFragment;
import com.example.esraa.bakingapp.fragment.StepVideoFragment;
import com.example.esraa.bakingapp.model.RecipeModel;
import com.example.esraa.bakingapp.util.Constants;

public class RecipesStepsActivity extends BaseActivity {
    private RecipeModel recipeModel;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_recipes_steps);
        if (bundle == null) {
            if (getIntent().getExtras() != null && getIntent().getExtras().containsKey(Constants.SELECTED_RECIPE_MODEL)) {
                recipeModel = (RecipeModel) getIntent().getExtras().getSerializable(Constants.SELECTED_RECIPE_MODEL);
            }
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.recipes_frame_layout, RecipeDetailsFragment.newInstance(recipeModel)).commit();
            if (isTablet()) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.steps_video_frame_layout, StepVideoFragment.newInstance(
                                recipeModel.getSteps().get(0).getVideoURL())).commit();
            }
        }
    }

}
