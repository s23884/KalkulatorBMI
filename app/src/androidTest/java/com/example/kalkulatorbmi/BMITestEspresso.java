package com.example.kalkulatorbmi;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import com.example.kalkulatorbmi.BMIActivity;

@LargeTest
public class BMITestEspresso {

    @Rule
    public ActivityScenarioRule<BMIActivity> activityRule =
            new ActivityScenarioRule<>(BMIActivity.class);

    @Test
    public void calculateBMICorrectly() {
        // Wpisz dane wejściowe
        Espresso.onView(ViewMatchers.withId(R.id.weight))
                .perform(typeText("70"));

        Espresso.onView(ViewMatchers.withId(R.id.height))
                .perform(typeText("170"));

        // Kliknij przycisk obliczenia BMI
        Espresso.onView(ViewMatchers.withId(R.id.btnOblicz))
                .perform(click());

        // Sprawdź, czy wynik jest poprawnie wyświetlany
        Espresso.onView(ViewMatchers.withId(R.id.result))
                .check(matches(isDisplayed()))
                .check(matches(withText("BMI: 24.22")));
    }
}
