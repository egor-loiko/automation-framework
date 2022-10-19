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
