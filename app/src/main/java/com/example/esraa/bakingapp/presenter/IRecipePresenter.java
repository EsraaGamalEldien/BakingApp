package com.example.esraa.bakingapp.presenter;

import com.example.esraa.bakingapp.model.RecipeModel;

public interface IRecipePresenter {
    void callGetAllReceiptsApi();

    void navigateToDetails(RecipeModel recipeModel);
}
