package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        loginPage.inputUsername("student");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmitButton();
    }

    @Test(priority = 1)
    public void userCanLogOut() {
        profilePage.clickOnLogOutButton();
        Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
    }

}
