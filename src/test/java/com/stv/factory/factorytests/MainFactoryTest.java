package com.stv.factory.factorytests;

import com.stv.factory.factorypages.CreateNewAccountPage;
import com.stv.factory.factorypages.LoginPage;
import com.stv.factory.factorypages.MainFactoryPage;
import com.stv.factory.factorypages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static com.stv.framework.core.messages.Messages.*;

public class MainFactoryTest extends BasicFactoryTest {

    MainFactoryPage mainFactoryPage = new MainFactoryPage();
    LoginPage loginPage = new LoginPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    CreateNewAccountPage createNewAccountPage = new CreateNewAccountPage();


    @DataProvider
    public Object[][] validUserData() {
        return new Object[][]{
                {"some_email@gmail.com", "111111", "First_Name", "https://www.wiggle.co.uk/secure/account"},
        };
    }

    @DataProvider
    public Object[][] invalidPasswordUserData() {
        return new Object[][]{
                {"some_email@gmail.com", "222222"},
        };
    }

    @DataProvider
    public Object[][] invalidEmailUserData() {
        return new Object[][]{
                {"some_invalid_email@gmail.com", "111111"},
        };
    }

    @DataProvider
    public Object[][] newUserData() {
        return new Object[][]{
                {"some_email_new@gmail.com"},
        };
    }

    @DataProvider
    public Object[][] existingUserData() {
        return new Object[][]{
                {"some_email@gmail.com"},
        };
    }

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

    @Test(description = "User with correct credentials is logged in", dataProvider = "validUserData")
    public void assertUserCorrectCredentialLoggedIn(String email, String password, String firstName, String accountURL) {
        mainFactoryPage.clickOnTrustButton();
        mainFactoryPage.clickOnAccountLink();
        loginPage.enterEmailAddressLogin(email);
        loginPage.enterPassword(password);
        loginPage.clickSignInSecurelyButton();
        Assert.assertEquals(myAccountPage.getFirstNameInfoFromGreetingLabel(), firstName, "Name is not correct");
        Assert.assertEquals(getDriver().getCurrentUrl(), accountURL, "Page is not correct");
        myAccountPage.clickSignOutButton();

    }

    @Test(description = "User with incorrect password - login error", dataProvider = "invalidPasswordUserData")
    public void assertUserIncorrectPasswordLoggedIn(String email, String password) {
        mainFactoryPage.clickOnTrustButton();
        mainFactoryPage.clickOnAccountLink();
        loginPage.enterEmailAddressLogin(email);
        loginPage.enterPassword(password);
        loginPage.clickSignInSecurelyButton();
        Assert.assertEquals(loginPage.getLoginErrorMessage(), LOGIN_ERROR_MESSAGE, "Messages are not matched");

    }

    @Test(description = "User with incorrect email - login error", dataProvider = "invalidEmailUserData")
    public void assertUserIncorrectEmailLoggedIn(String email, String password) {
        mainFactoryPage.clickOnTrustButton();
        mainFactoryPage.clickOnAccountLink();
        loginPage.enterEmailAddressLogin(email);
        loginPage.enterPassword(password);
        loginPage.clickSignInSecurelyButton();
        Assert.assertEquals(loginPage.getLoginErrorMessage(), LOGIN_ERROR_MESSAGE, "Messages are not matched");

    }

    @Test(description = "Create new customer - not existing user", dataProvider = "newUserData")
    public void createNewCustomerNotExistingUser(String email) {
        mainFactoryPage.clickOnTrustButton();
        mainFactoryPage.clickOnAccountLink();
        loginPage.enterEmailAddressNewCustomer(email);
        loginPage.clickContinueButton();
        Assert.assertEquals(createNewAccountPage.isContinueButtonDisplayed(), true, "Page is not loaded");

    }

    @Test(description = "Create new customer - existing user", dataProvider = "existingUserData")
    public void createNewCustomerExistingUser(String email) {
        mainFactoryPage.clickOnTrustButton();
        mainFactoryPage.clickOnAccountLink();
        loginPage.enterEmailAddressNewCustomer(email);
        loginPage.clickContinueButton();
        Assert.assertEquals(loginPage.getNewCustomerErrorMessage(), CREATE_NEW_USER_ERROR_MESSAGE, "Messages are not matched");

    }
}