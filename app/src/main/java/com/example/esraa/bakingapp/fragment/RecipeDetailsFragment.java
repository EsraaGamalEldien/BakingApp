package com.example.esraa.bakingapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.esraa.bakingapp.R;
import com.example.esraa.bakingapp.adapter.StepsAdapter;
import com.example.esraa.bakingapp.model.Ingredients;
import com.example.esraa.bakingapp.model.RecipeModel;
import com.example.esraa.bakingapp.model.Steps;
import com.example.esraa.bakingapp.presenter.IRecipeDetailsPresenter;
import com.example.esraa.bakingapp.presenter.RecipeDetailsPresenter;
import com.example.esraa.bakingapp.util.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeDetailsFragment extends Fragment implements RecipeDetailsFragmentView {
    @BindView(R.id.ingredients_label_text_view)
    TextView ingredientsLabel;
    @BindView(R.id.ingredients_text_view)
    TextView ingredients;
    @BindView(R.id.recipe_steps_recycler_View)
    RecyclerView stepsRecyclerView;
    @BindView(R.id.recipe_name_text_view)
    TextView recipeNameTextView;
    private RecipeModel recipeModel;
    private IRecipeDetailsPresenter presenter;

    public static RecipeDetailsFragment newInstance(RecipeModel recipeModel) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.SELECTED_RECIPE_MODEL, recipeModel);
        RecipeDetailsFragment fragment = new RecipeDetailsFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recipe_details, container, false);
        ButterKnife.bind(this, rootView);
        if (getArguments() != null && getArguments().containsKey(Constants.SELECTED_RECIPE_MODEL)) {
            recipeModel = (RecipeModel) getArguments().getSerializable(Constants.SELECTED_RECIPE_MODEL);
        }
        presenter = new RecipeDetailsPresenter((AppCompatActivity) getActivity());
        setUiValues();
        return rootView;
    }

    private void setUiValues() {
        recipeNameTextView.setText(recipeModel.getName());
        setIngredients();
        setStepsToRecyclerView();
    }

    private void setStepsToRecyclerView() {
        if (presenter.isTablet()) {
            stepsRecyclerView.setLayoutManager(
                    new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        } else {
            stepsRecyclerView.setLayoutManager(
                    new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        }
        StepsAdapter stepsAdapter = new StepsAdapter(recipeModel.getSteps(), this);
        stepsRecyclerView.setAdapter(stepsAdapter);
        stepsAdapter.notifyDataSetChanged();
    }

    private void setIngredients() {
        String allIngredients = "";
        for (int i = 0; i < recipeModel.getIngredients().size(); i++) {
            Ingredients ingredient = recipeModel.getIngredients().get(i);
            allIngredients = String.format("%s %s %s %s\n", allIngredients,
                    ingredient.getQuantity(), ingredient.getIngredient(), ingredient.getMeasure());
        }
        ingredients.setText(allIngredients);
    }


    @Override
    public void navigateToStepDetails(Steps step) {
        presenter.navigateToStepDetails(step);
    }


    @Override
    public void onPause() {
        super.onPause();
    }
}
