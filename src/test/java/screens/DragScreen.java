package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.BaseScreen;

public class DragScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Drag and Drop\")")
    private AndroidElement dragTitle;

    public DragScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public boolean isDragTitleCorrect(String title) {
        return isTitleCorrect(dragTitle, title);
    }
}
