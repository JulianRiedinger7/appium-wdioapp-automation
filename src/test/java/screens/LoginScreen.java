package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.BaseScreen;

public class LoginScreen extends BaseScreen {

    @AndroidFindBy(accessibility = "input-email")
    private AndroidElement inputEmail;

    @AndroidFindBy(accessibility = "input-password")
    private AndroidElement inputPassword;

    @AndroidFindBy(accessibility = "input-repeat-password")
    private AndroidElement inputRepeatPassword;

    @AndroidFindBy(accessibility = "button-SIGN UP")
    private AndroidElement signUpBtn;

    @AndroidFindBy(accessibility = "button-LOGIN")
    private AndroidElement loginBtn;

    @AndroidFindBy(accessibility = "button-login-container")
    private AndroidElement loginRedirect;

    @AndroidFindBy(accessibility = "button-sign-up-container")
    private AndroidElement signUpRedirect;

    @AndroidFindBy(id = "android:id/message")
    private AndroidElement alertMessage;

    @AndroidFindBy(id = "android:id/button1")
    private AndroidElement alertOkBtn;

    public LoginScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void goToSignUpForm() {
        tapByElement(signUpRedirect);
    }

    public void goToLoginForm() {
        tapByElement(loginRedirect);
    }

    public void signUp(String email, String password) {
        setText(inputEmail, email);
        setText(inputPassword, password);
        setText(inputRepeatPassword, password);

        tapByElement(signUpBtn);
    }

    public void login(String email, String password) {
        setText(inputEmail, email);
        setText(inputPassword, password);

        tapByElement(loginBtn);
    }

    public String getAlertMessageText() {
        waitElementVisibility(alertMessage);
        return alertMessage.getText();
    }

    public void acceptAlert() {
        tapByElement(alertOkBtn);
    }

}
