package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.BaseScreen;

public class BottomNavigationScreen extends BaseScreen {

    @AndroidFindBy(accessibility = "Home")
    private AndroidElement homeBtn;

    @AndroidFindBy(accessibility = "Login")
    private AndroidElement loginBtn;

    @AndroidFindBy(accessibility = "Webview")
    private AndroidElement webviewBtn;

    @AndroidFindBy(accessibility = "Forms")
    private AndroidElement formsBtn;

    @AndroidFindBy(accessibility = "Swipe")
    private AndroidElement swipeBtn;

    @AndroidFindBy(accessibility = "Drag")
    private AndroidElement dragBtn;

    public BottomNavigationScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public LoginScreen goToLogin() {
        tapByElement(loginBtn);
        return new LoginScreen(driver);
    }
}
