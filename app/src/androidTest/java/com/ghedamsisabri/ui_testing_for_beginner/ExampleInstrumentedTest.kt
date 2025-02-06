package com.ghedamsisabri.ui_testing_for_beginner

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.ghedamsisabri.ui_testing_for_beginner.Helper.getText
import com.ghedamsisabri.ui_testing_for_beginner.Helper.isTextOnScreen
import com.ghedamsisabri.ui_testing_for_beginner.Helper.isViewDisplayed
import com.ghedamsisabri.ui_testing_for_beginner.Helper.tap
import org.hamcrest.Matcher
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule


@RunWith(AndroidJUnit4::class)
@LargeTest
class ExampleInstrumentedTest {

    @get:Rule var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun checkSecondPage() {
        NextBtn.tap()
        secondPageActivity.isViewDisplayed()

        isTextOnScreen("SecondaryActivity")
        Assert.assertEquals("SecondaryActivity", secondPageActivity.getText(5))
    }

    @Test
    fun checkNavigationToSecondPage() {
        // 1. Check that the main page is loaded
        mainPageText.isViewDisplayed()

        // 2. click next button on the first page
        NextBtn.tap()

        // 3. Check second page

        // ·  Second page text is on the screen
        isTextOnScreen(secondPageActivity.getText())
        // ·  Back button is on the screen
        backButton.isViewDisplayed()
    }

    @Test
    fun checkBackNavigationToMainPage() {
        // 1 Check that the main page is loaded
        mainPageText.isViewDisplayed()

        // 2. click next button on the first page
        NextBtn.tap()

        // 3. go back with the back Button
        backButton.tap()

        // 4. Validate main page components
        // ·  Main page text is on the screen
        isTextOnScreen(mainPageText.getText())
        // ·  The next button is on the screen
        NextBtn.isViewDisplayed()
    }

    companion object{
        val NextBtn: Matcher<View> by lazy { withId(R.id.button_next_activity) }
        val secondPageActivity: Matcher<View> by lazy { withId(R.id.activity_secondary_title) }
        val backButton: Matcher<View> by lazy { withId(R.id.button_back) }
        val mainPageText: Matcher<View> by lazy { withId(R.id.activity_main_title) }
    }
}