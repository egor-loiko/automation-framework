package com.stv.factory.factorypages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainFactoryPage extends FactoryPage {

    @FindBy(id = "accountLink")
    private WebElement accountLink;

    @FindBy(xpath = "//button[contains(text(),'Accept All Cookies')]")
    private WebElement trustButton;

    public boolean isAccountLinkDisplayed() {
        return accountLink.isDisplayed();
    }

    public void clickOnAccountLink() {
        accountLink.click();
    }
/*
This method is necessary for the determining whether 'Accept all cookies' button is present on the page
This is required for group test run (because for the second and consequent tests popup with 'Accept all cookies' button is not present)
We try to reach button and in case when button is not present NoSuchElementException is thrown and step with button click is skipped
*/
    public boolean isTrustButtonDisplayed() {
        try {
            trustButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public void clickOnTrustButton() {
        if (isTrustButtonDisplayed()) {
            trustButton.click();
        }
    }

}
