package com.example.android.pets;


import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.notNullValue;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CatalogActivityTest {

    @Rule
    public IntentsTestRule<CatalogActivity> intentsTestRule =
            new IntentsTestRule<>(CatalogActivity.class);

    @Test
    public void triggerIntentTest() {
        onView(withId(R.id.fab)).check(matches(notNullValue()));
        onView(withId(R.id.fab)).perform(click());
        intended(hasComponent(EditorActivity.class.getName()));
    }
}
