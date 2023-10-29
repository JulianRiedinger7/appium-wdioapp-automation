package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.BottomNavigationScreen;
import screens.LoginScreen;
import utils.BaseTest;

public class LoginTest extends BaseTest {

    LoginScreen loginForms;

    @Test
    @Parameters({"email", "password"})
    public void successfullySignupTest(String email, String password) {
        BottomNavigationScreen bottomNavigation = loadNavigationScreen();

        loginForms = bottomNavigation.goToLogin();

        loginForms.goToSignUpForm();
        loginForms.signUp(email, password);

        Assert.assertEquals(loginForms.getAlertMessageText(), "You successfully signed up!", "Signup Incorrect");
        loginForms.acceptAlert();

    }

    @Test(dependsOnMethods = "successfullySignupTest")
    @Parameters({"email", "password"})
    public void successfullyLoginTest(String email, String password) {
        loginForms.goToLoginForm();
        loginForms.login(email, password);

        Assert.assertEquals(loginForms.getAlertMessageText(), "You are logged in!", "Login Incorrect");
        loginForms.acceptAlert();
    }
}
