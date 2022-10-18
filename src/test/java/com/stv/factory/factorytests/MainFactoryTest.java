package com.stv.factory.factorytests;

import com.stv.factory.factorypages.CreateNewAccountPage;
import com.stv.factory.factorypages.LoginPage;
import com.stv.factory.factorypages.MainFactoryPage;
import com.stv.factory.factorypages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.stv.framework.core.messages.Messages.*;

public class MainFactoryTest extends BasicFactoryTest {

    MainFactoryPage mainFactoryPage = new MainFactoryPage();
    LoginPage loginPage = new LoginPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    CreateNewAccountPage createNewAccountPage = new CreateNewAccountPage();
//    @Test (description = "Assert the main page is loaded and account icon is visible")
//    public void assertAccountIconIsDisplayed() {
//        boolean actualResult = mainFactoryPage .isAccountLinkDisplayed();
//        Assert.assertEquals(actualResult, true, "Account link isn't visible");
//    }
//
//    @Test (description = "Assert the login page is loaded", dependsOnMethods = "assertAccountIconIsDisplayed")
//    public void assertLoginPageOpened() {
//        mainFactoryPage.clickOnTrustButton();
//        mainFactoryPage.clickOnAccountLink();
//        Assert.assertEquals(new LoginPage().isLoginContainerDisplayed(), true, "Login page isn't loaded properly");
//    }

    @Test(description = "User with correct credentials is logged in")
    public void assertUserCorrectCredentialLoggedIn() {
        mainFactoryPage.clickOnTrustButton();
        mainFactoryPage.clickOnAccountLink();
        loginPage.enterEmailAddressLogin("some_email@gmail.com");
        loginPage.enterPassword("111111");
        loginPage.clickSignInSecurelyButton();
        Assert.assertEquals(myAccountPage.getFirstNameInfoFromGreetingLabel(), "First_Name", "Name is not correct");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.wiggle.co.uk/secure/account", "Page is not correct");
        myAccountPage.clickSignOutButton();

    }

    @Test(description = "User with incorrect password - login error")
    public void assertUserIncorrectPasswordLoggedIn() {
        mainFactoryPage.clickOnTrustButton();
        mainFactoryPage.clickOnAccountLink();
        loginPage.enterEmailAddressLogin("some_email@gmail.com");
        loginPage.enterPassword("222222");
        loginPage.clickSignInSecurelyButton();
        Assert.assertEquals(loginPage.getLoginErrorMessage(), LOGIN_ERROR_MESSAGE, "Messages are not matched");

    }

    @Test(description = "User with incorrect email - login error")
    public void assertUserIncorrectEmailLoggedIn() {
        mainFactoryPage.clickOnTrustButton();
        mainFactoryPage.clickOnAccountLink();
        loginPage.enterEmailAddressLogin("some_invalid_email@gmail.com");
        loginPage.enterPassword("111111");
        loginPage.clickSignInSecurelyButton();
        Assert.assertEquals(loginPage.getLoginErrorMessage(), LOGIN_ERROR_MESSAGE, "Messages are not matched");

    }

    @Test(description = "Create new customer - not existing user")
    public void createNewCustomerNotExistingUser() {
        mainFactoryPage.clickOnTrustButton();
        mainFactoryPage.clickOnAccountLink();
        loginPage.enterEmailAddressNewCustomer("some_email_new@gmail.com");
        loginPage.clickContinueButton();
        Assert.assertEquals(createNewAccountPage.isContinueButtonDisplayed(), true, "Page is not loaded");

    }

    @Test(description = "Create new customer - existing user")
    public void createNewCustomerExistingUser() {
        mainFactoryPage.clickOnTrustButton();
        mainFactoryPage.clickOnAccountLink();
        loginPage.enterEmailAddressNewCustomer("some_email@gmail.com");
        loginPage.clickContinueButton();
        Assert.assertEquals(loginPage.getNewCustomerErrorMessage(), CREATE_NEW_USER_ERROR_MESSAGE, "Messages are not matched");

    }
}