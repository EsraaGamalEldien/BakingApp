package com.example.esraa.bakingapp.fragment;

import com.example.esraa.bakingapp.model.RecipeModel;

import java.util.List;

public interface ReceiptsFragmentView {
    void viewUiWithReceiptsResponse(List<RecipeModel> recipeModelList);

    void viewFailResponse();

    void navigateToRecipeDetails(RecipeModel recipeModel);
}
