package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import screens.BottomNavigationScreen;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    AndroidDriver<AndroidElement> driver;

    Dotenv dotenv = Dotenv.load();

    @BeforeTest
    public void beforeTest() {
        DesiredCapabilities capabilities = environmentSetup();

        try {
            driver = new AndroidDriver<>(new URL(dotenv.get("URL")), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private DesiredCapabilities environmentSetup() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:deviceName", dotenv.get("DEVICE_NAME"));
        capabilities.setCapability("appium:platformVersion", dotenv.get("PLATFORM_VERSION"));
        capabilities.setCapability("appium:appPackage", "com.wdiodemoapp");
        capabilities.setCapability("appium:appActivity", ".MainActivity");
        capabilities.setCapability("appium:ensureWebviewsHavePages", true);
        capabilities.setCapability("appium:nativeWebScreenshot", true);
        capabilities.setCapability("appium:newCommandTimeout", 3600);
        capabilities.setCapability("appium:connectHardwareKeyboard", true);
        return capabilities;
    }

    public BottomNavigationScreen loadNavigationScreen() {
        return new BottomNavigationScreen(driver);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
