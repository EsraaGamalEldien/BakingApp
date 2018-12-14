package com.example.esraa.bakingapp;


import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.esraa.bakingapp.activity.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkSelectingSecondRecipe() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(ViewMatchers.withId(R.id.receipts_recycler_View)).perform(actionOnItemAtPosition(1, click()));
        onView(withId(R.id.recipe_steps_recycler_View)).check(matches(isDisplayed()));

    }

    @Test
    public void checkSelectingRecipe() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(ViewMatchers.withId(R.id.receipts_recycler_View)).perform(actionOnItemAtPosition(0, click()));
        onView(withText("Ingredients")).check(matches(notNullValue()));
    }


    @Test
    public void checkRecipeDetails() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(ViewMatchers.withId(R.id.receipts_recycler_View)).perform(actionOnItemAtPosition(0, click()));
        onView(withText("Ingredients")).check(matches(notNullValue()));
        onView(ViewMatchers.withId(R.id.recipe_steps_recycler_View)).perform(actionOnItemAtPosition(0, click()));
        onView(withId(R.id.video_view)).check(matches(isDisplayed()));
    }
}
