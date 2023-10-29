package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import screens.*;
import utils.BaseTest;

import java.util.Set;

public class NavigationTest extends BaseTest {

    BottomNavigationScreen bottomNavigation;

    @BeforeClass
    public void setup() {
        bottomNavigation = loadNavigationScreen();
    }

    @Test
    public void homeNavigationTest() {
        HomeScreen home = bottomNavigation.goToHome();

        Assert.assertTrue(home.isHomeTitleCorrect("WEBDRIVER"), "The titles does not match");
    }

    @Test
    public void formsNavigationTest() {
        FormsScreen forms = bottomNavigation.goToForms();

        Assert.assertTrue(forms.isFormsTitleCorrect("Form components"), "The titles does not match");
        Assert.assertTrue(forms.isActiveBtnPressable(), "The active button is not pressable");
    }

    @Test
    public void swipeNavigationTest() {
        SwipeScreen swipe = bottomNavigation.goToSwipe();

        Assert.assertTrue(swipe.isSwipeTitleCorrect("Swipe horizontal"), "The titles does not match");
        Assert.assertTrue(swipe.isCarouselDisplayed(), "The carousel is not displayed");
    }

    @Test
    public void dragNavigationTest() {
        DragScreen drag = bottomNavigation.goToDrag();

        Assert.assertTrue(drag.isDragTitleCorrect("Drag and Drop"), "The titles does not match");
    }

    @Test
    @Ignore
    public void WebviewNavigationTest() {
        bottomNavigation.goToWebview();

        changeToWebviewContext();

        WebviewScreen webview = loadWebviewScreen();

        Assert.assertTrue(webview.isWebviewTitleCorrect("Next-gen browser and mobile automation test framework for Node.js"), "The titles does not match");
        Assert.assertTrue(webview.isGetStartedBtnClickable(), "Get started button is not clickable");

        changeToAppContext();
    }
}
