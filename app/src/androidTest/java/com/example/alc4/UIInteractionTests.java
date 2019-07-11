package com.example.alc4;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
//Coded UI Test
public class UIInteractionTests {

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void loadAboutALCActivity() {
        onView(withId(R.id.btn_about_alc)).perform(click());
        pressBack();
    }

    @Test
    public void loadProfileActivity(){
        onView(withId(R.id.btn_profile)).perform(click());
        pressBack();
    }
}