package com.example.android.pets;


import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.AllOf.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class EditorActivityTest {

    @Rule
    public ActivityTestRule<EditorActivity> mActivityTestRule = new ActivityTestRule<>(EditorActivity.class);

    @Test
    public void editorActivityEditTextTest() {
        onView(withId(R.id.edit_pet_name)).check(matches(notNullValue()));
        onView(withId(R.id.edit_pet_name)).check(matches(withHint("Name")));
        onView(withId(R.id.edit_pet_name)).perform(typeText("Yoyo"), closeSoftKeyboard());
        onView(withId(R.id.edit_pet_name)).check(matches(withText("Yoyo")));
    }

    @Test
    public void editorActivitySpinnerTest() {
        onView(withId(R.id.spinner_gender)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Male"))).perform(click());
        onView(withId(R.id.spinner_gender)).check(matches(withSpinnerText(containsString("Male"))));
    }
}
