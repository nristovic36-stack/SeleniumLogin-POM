package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    String validUsername, validPassword, invalidUsername, invalidPassword;
    @BeforeMethod
    public void pageSetUp() {
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        validUsername = "student";
        validPassword = "Password123";
        invalidUsername = "non student";
        invalidPassword = "password";
    }

    @AfterMethod
    public void clearCookies() {
        driver.manage().deleteAllCookies();
    }

    @Test(priority = 1)
    public void userCanLogIn() {
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(profilePage.getLoggedInMessage().isDisplayed());
        Assert.assertTrue(profilePage.getLogOutButton().isDisplayed());
    }

    @Test(priority = 2)
    public void userCannotLogInWithInvalidUsername() {
        loginPage.inputUsername(invalidUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnSubmitButton();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getError()));
        Assert.assertTrue(loginPage.getError().isDisplayed());
        Assert.assertEquals(loginPage.errorText(), "Your username is invalid!");
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
    }

    @Test(priority = 3)
    public void userCannotLogInWithInvalidPassword() {
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(invalidPassword);
        loginPage.clickOnSubmitButton();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getError()));
        Assert.assertTrue(loginPage.getError().isDisplayed());
        Assert.assertEquals(loginPage.errorText(), "Your password is invalid!");
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
    }

    @Test(priority = 4)
    public void userCannotLogInWithEmptyUsernameField() {
        loginPage.inputUsername("");
        loginPage.inputPassword(validPassword);
        loginPage.clickOnSubmitButton();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getError()));
        Assert.assertTrue(loginPage.getError().isDisplayed());
        Assert.assertEquals(loginPage.errorText(), "Your username is invalid!");
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
    }

    @Test(priority = 5)
    public void userCannotLogInWithEmptyPasswordField() {
        loginPage.inputUsername(validUsername);
        loginPage.inputPassword("");
        loginPage.clickOnSubmitButton();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getError()));
        Assert.assertTrue(loginPage.getError().isDisplayed());
        Assert.assertEquals(loginPage.errorText(), "Your password is invalid!");
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
    }


}
