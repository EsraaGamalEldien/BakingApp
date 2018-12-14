package com.example.esraa.bakingapp.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.esraa.bakingapp.R;
import com.example.esraa.bakingapp.activity.RecipesStepsActivity;
import com.example.esraa.bakingapp.fragment.ReceiptsFragmentView;
import com.example.esraa.bakingapp.fragment.RecipeDetailsFragment;
import com.example.esraa.bakingapp.model.RecipeModel;
import com.example.esraa.bakingapp.retrofit.ApiClient;
import com.example.esraa.bakingapp.util.Constants;
import com.example.esraa.bakingapp.widget.UpdateWidgetIntentService;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.esraa.bakingapp.BakingApplicationClass.getContext;

public class RecipePresenter extends BasePresenter implements IRecipePresenter {
    private Context context;
    private ReceiptsFragmentView receiptsFragmentView;
    private AppCompatActivity activity;

    public RecipePresenter(AppCompatActivity activity, Context context, ReceiptsFragmentView receiptsFragmentView) {
        super(activity);
        this.activity = activity;
        this.context = context;
        this.receiptsFragmentView = receiptsFragmentView;

    }

    @Override
    public void callGetAllReceiptsApi() {
        progressDialog.show();
        ApiClient.getApiClientInstance().getApiService(context).getAllReceipts()
                .enqueue(new Callback<List<RecipeModel>>() {
                    @Override
                    public void onResponse(Call<List<RecipeModel>> call, Response<List<RecipeModel>> response) {
                        if (progressDialog.isShowing())
                            progressDialog.dismiss();
                        List<RecipeModel> recipeModelList = response.body();
                        receiptsFragmentView.viewUiWithReceiptsResponse(recipeModelList);
                    }

                    @Override
                    public void onFailure(Call<List<RecipeModel>> call, Throwable t) {
                        if (progressDialog.isShowing())
                            progressDialog.dismiss();
                        receiptsFragmentView.viewFailResponse();
                    }
                });
    }

    private void saveAndUpdateAppWidget(RecipeModel recipeModel){
        UpdateWidgetIntentService.startActionUpdateWidgetRecipe(getContext(),new Gson().toJson(recipeModel));
    }

    @Override
    public void navigateToDetails(RecipeModel recipeModel) {
        saveAndUpdateAppWidget(recipeModel);
        Intent intent = new Intent(activity, RecipesStepsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.SELECTED_RECIPE_MODEL,recipeModel);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

}
