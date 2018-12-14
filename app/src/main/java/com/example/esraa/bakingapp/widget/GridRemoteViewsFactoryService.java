package com.example.esraa.bakingapp.widget;

import android.content.Context;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.example.esraa.bakingapp.R;
import com.example.esraa.bakingapp.SharedPreferenceManager;
import com.example.esraa.bakingapp.model.Ingredients;
import com.example.esraa.bakingapp.model.RecipeModel;
import com.example.esraa.bakingapp.util.Constants;
import com.google.gson.Gson;

import java.util.List;

class GridRemoteViewsFactoryService implements RemoteViewsService.RemoteViewsFactory {
    private Context context;
    private List<Ingredients> ingredientsList;
    private Gson gson;
    private static final String ASTERISK ="*";

    public GridRemoteViewsFactoryService(Context context) {
        this.context = context;
        gson = new Gson();
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {
        String recipeJson = SharedPreferenceManager.getInstance().getString(
                Constants.SELECTED_RECIPE_MODEL, "");
        RecipeModel model = gson.fromJson(recipeJson, RecipeModel.class);
        ingredientsList = model.getIngredients();

    }


    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        if (ingredientsList == null) return 0;
        return ingredientsList.size();
    }

    @Override
    public RemoteViews getViewAt(int i) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.recipe_widget);
        views.setTextViewText(R.id.ingredient_widget_text_view, String.format("%s%s", ASTERISK,
                ingredientsList.get(i).getIngredient()));
        return views;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
