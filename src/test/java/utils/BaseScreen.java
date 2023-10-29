package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class BaseScreen {

    protected AndroidDriver<AndroidElement> driver;
    protected WebDriverWait wait;

    public BaseScreen(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.wait = new WebDriverWait(driver, 15);
    }

    protected void waitElementPressable(AndroidElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitElementVisibility(AndroidElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void tapByElement(AndroidElement element) {
        waitElementPressable(element);
        new TouchAction(driver)
                .tap(new TapOptions().withElement(ElementOption.element(element)))
                .perform();
    }

    protected void setText(AndroidElement element, String text) {
        waitElementVisibility(element);
        element.sendKeys(text);
    }

    protected boolean isElementDisplayed(AndroidElement element) {
        try {
            waitElementVisibility(element);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
