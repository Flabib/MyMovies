package id.practice.mymovies

import androidx.recyclerview.widget.RecyclerView
import androidx.test.rule.ActivityTestRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import id.practice.mymovies.data.Catalogue
import id.practice.mymovies.ui.main.MainActivity
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    private var dummyData = Catalogue.loadData()

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyData.movie.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
            ViewActions.click()
        ))
        onView(withId(R.id.tvtitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvtitle)).check(matches(withText(dummyData.movie[0].title)))
        onView(withId(R.id.release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.release_date)).check(matches(withText(dummyData.movie[0].releaseDate)))
    }

    @Test
    fun loadTV() {
        onView(withId(R.id.navigation_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.navigation_tv)).perform(ViewActions.click())
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyData.movie.size))
    }

    @Test
    fun loadDetailTV() {
        onView(withId(R.id.navigation_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.navigation_tv)).perform(ViewActions.click())
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
            ViewActions.click()
        ))
        onView(withId(R.id.tvtitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvtitle)).check(matches(withText(dummyData.tv[0].title)))
        onView(withId(R.id.release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.release_date)).check(matches(withText(dummyData.tv[0].releaseDate)))
    }
}