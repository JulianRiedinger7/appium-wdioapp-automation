package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.BaseScreen;

public class FormsScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Form components\")")
    private AndroidElement formsTitle;

    @AndroidFindBy(accessibility = "button-Active")
    private AndroidElement activeBtn;


    public FormsScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public boolean isFormsTitleCorrect(String title) {
        return isTitleCorrect(formsTitle, title);
    }

    public boolean isActiveBtnPressable() {
        try {
            waitElementPressable(activeBtn);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
