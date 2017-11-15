package cc.somkiat.basicunittesting;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void saveEmptyNameAndEmptyEmail() {
        onView(withId(R.id.userNameInput)).perform(scrollTo(), replaceText(""), closeSoftKeyboard());
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText(""), closeSoftKeyboard());
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        checkToastDisplayed("Name is empty");
    }

    @Test
    public void saveValidNameAndEmptyEmail() {
        onView(withId(R.id.userNameInput)).perform(scrollTo(), replaceText("Nakarin Kakanumporn"), closeSoftKeyboard());
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText(""), closeSoftKeyboard());
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        checkToastDisplayed("Email is empty");
    }

    @Test
    public void saveInvalidNameAndEmptyEmail() {
        onView(withId(R.id.userNameInput)).perform(scrollTo(), replaceText("[Since1996] Nakarin Kakanumporn"), closeSoftKeyboard());
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText(""), closeSoftKeyboard());
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        checkToastDisplayed("Name contains non alphabet character");
    }

    @Test
    public void saveMixLangInNameAndEmptyEmail() {
        onView(withId(R.id.userNameInput)).perform(scrollTo(), replaceText("Nakarin คัคนัมพร"), closeSoftKeyboard());
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText(""), closeSoftKeyboard());
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        checkToastDisplayed("Name contains mix language");
    }

    @Test
    public void saveValidNameAndInvaliEmail() {
        onView(withId(R.id.userNameInput)).perform(scrollTo(), replaceText("Nakarin Kakanumporn"), closeSoftKeyboard());
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("belizwp@live.123"), closeSoftKeyboard());
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        checkToastDisplayed("Email is invalid");
    }

    @Test
    public void saveValidNameAndValiEmail() {
        onView(withId(R.id.userNameInput)).perform(scrollTo(), replaceText("Nakarin Kakanumporn"), closeSoftKeyboard());
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("belizwp@live.com"), closeSoftKeyboard());
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        checkToastDisplayed("Save");
    }

    @Test
    public void revert() {
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).check(matches(withText("")));
        onView(withId(R.id.emailInput)).check(matches(withText("")));
        checkToastDisplayed("Revert");
    }

    private void checkToastDisplayed(String text) {
        onView(withText(text))
                .inRoot(withDecorView(not(is(mActivityTestRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }
}
