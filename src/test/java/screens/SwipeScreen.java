package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.BaseScreen;

public class SwipeScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Swipe Horizontal\")")
    private AndroidElement swipeTitle;

    @AndroidFindBy(accessibility = "Carousel")
    private AndroidElement carouselContainer;

    public SwipeScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public boolean isSwipeTitleCorrect(String title) {
        return isTitleCorrect(swipeTitle, title);
    }

    public boolean isCarouselDisplayed() {
        return isElementDisplayed(carouselContainer);
    }
}
