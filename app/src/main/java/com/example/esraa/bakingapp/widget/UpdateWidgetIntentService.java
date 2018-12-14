package com.example.esraa.bakingapp.widget;

import android.app.IntentService;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.example.esraa.bakingapp.R;
import com.example.esraa.bakingapp.SharedPreferenceManager;
import com.example.esraa.bakingapp.util.Constants;

public class UpdateWidgetIntentService extends IntentService {

    public static final String ACTION_UPDATE_RECIPE_WIDGET =
            "com.example.esraa.bakingapp.action.update_RECIPE_widgets";


    public UpdateWidgetIntentService() {
        super("UpdateWidgetIntentService");
    }

    public static void startActionUpdateWidgetRecipe(Context context, String recipeModelGson) {
        Intent intent = new Intent(context, UpdateWidgetIntentService.class);
        intent.setAction(ACTION_UPDATE_RECIPE_WIDGET);
        intent.putExtra(Constants.SELECTED_RECIPE_MODEL, recipeModelGson);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null && intent.getAction() != null &&
                intent.getAction().equals(ACTION_UPDATE_RECIPE_WIDGET)) {
            SharedPreferenceManager.getInstance().saveString(Constants.SELECTED_RECIPE_MODEL,
                    intent.getStringExtra(Constants.SELECTED_RECIPE_MODEL));

            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(
                    this, BakingAppWidget.class));
            appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.widget_grid_view);
            BakingAppWidget.updateBakingAppWidgets(this, appWidgetManager, appWidgetIds);
        }
    }
}
