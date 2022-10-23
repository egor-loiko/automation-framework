package com.stv.bdd_framework.steps;

import com.stv.factory.factorypages.LoginPage;
import com.stv.factory.factorytests.BasicFactoryTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.stv.framework.core.messages.Messages.CREATE_NEW_USER_ERROR_MESSAGE;
import static com.stv.framework.core.messages.Messages.LOGIN_ERROR_MESSAGE;

public class LoginPageSteps extends BasicFactoryTest {
    LoginPage loginPage = new LoginPage();

    @And("Enter email {string} in Sign in block")
    public void enterInSignInBlock(String email) {
        loginPage.enterEmailAddressLogin(email);
    }

    @And("Enter password {string} in Sign in block")
    public void enterPasswordInSignInBlock(String password) {
        loginPage.enterPassword(password);
    }

    @When("Click Sign in securely button in Sign in block")
    public void clickSignInSecurelyButtonInSignInBlock() {
        loginPage.clickSignInSecurelyButton();
    }

    @Then("Invalid credentials validation message appears")
    public void validationMessageAppears() {
        Assert.assertEquals(loginPage.getLoginErrorMessage(), LOGIN_ERROR_MESSAGE, "Messages are not matched");
    }

    @And("Enter email {string} in New Customer block")
    public void enterEmailInNewCustomerBlock(String email) {
        loginPage.enterEmailAddressNewCustomer(email);
    }

    @When("Click Continue button")
    public void clickContinueButton() {
        loginPage.clickContinueButton();
    }

    @Then("User exists validation message appears")
    public void userExistsValidationMessageAppears() {
        Assert.assertEquals(loginPage.getNewCustomerErrorMessage(), CREATE_NEW_USER_ERROR_MESSAGE, "Messages are not matched");
    }
}
