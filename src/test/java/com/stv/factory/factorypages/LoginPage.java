package com.stv.factory.factorypages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends FactoryPage {
    @FindBy(className = "bem-checkout__login-container")
    private WebElement loginContainer;

    @FindBy(id = "LogOnModel_UserName")
    private WebElement emailAddressLoginInputField;

    @FindBy(id = "LogOnModel_Password")
    private WebElement passwordInputField;

    @FindBy(id = "qa-login")
    private WebElement signInSecurelyButton;

    @FindBy(className = "bem-alert--danger")
    private WebElement loginErrorMessage;

    @FindBy(id = "DualRegisterEmailModel_Email")
    private WebElement emailAddressNewCustomerInputField;

    @FindBy(id = "qa-dual-register")
    private WebElement continueButton;

    @FindBy(className = "bem-alert--danger")
    private WebElement createNewCustomerErrorMessage;

    public boolean isLoginContainerDisplayed() {
        return loginContainer.isDisplayed();
    }

    public void enterEmailAddressLogin(String emailAddress) {
        emailAddressLoginInputField.sendKeys(emailAddress);
    }

    public void enterPassword(String password) {
        passwordInputField.sendKeys(password);
    }

    public void clickSignInSecurelyButton() {
        signInSecurelyButton.click();
    }

    public String getLoginErrorMessage() {
        return loginErrorMessage.getText();
    }

    public void enterEmailAddressNewCustomer(String emailAddress) {
        emailAddressNewCustomerInputField.sendKeys(emailAddress);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public String getNewCustomerErrorMessage() {
        return createNewCustomerErrorMessage.getText();
    }
}

