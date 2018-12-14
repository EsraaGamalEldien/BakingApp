package com.example.esraa.bakingapp.presenter;

import com.example.esraa.bakingapp.model.Steps;

public interface IRecipeDetailsPresenter {
    void navigateToStepDetails(Steps step);

    boolean isTablet();
}
