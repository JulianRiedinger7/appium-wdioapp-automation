package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BaseScreen;

public class WebviewScreen extends BaseScreen {

    @FindBy(className = "hero__subtitle")
    private WebElement webviewTitle;

    @FindBy(css = ".button[href='/docs/gettingstarted']")
    private WebElement getStartedBtn;

    public WebviewScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public boolean isWebviewTitleCorrect(String title) {
        wait.until(ExpectedConditions.visibilityOf(webviewTitle));
        return webviewTitle.isDisplayed() && webviewTitle.getText().equalsIgnoreCase(title);
    }

    public boolean isGetStartedBtnClickable() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(getStartedBtn));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
