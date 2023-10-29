package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.BaseScreen;

public class HomeScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"WEBDRIVER\")")
    private AndroidElement homeTitle;

    public HomeScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public boolean isHomeTitleCorrect(String title) {
        return isTitleCorrect(homeTitle, title);
    }
}
