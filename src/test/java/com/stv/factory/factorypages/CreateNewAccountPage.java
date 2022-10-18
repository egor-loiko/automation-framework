package com.stv.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewAccountPage extends FactoryPage{

    @FindBy(id = "qa-register")
    private WebElement continueButton;

    public boolean isContinueButtonDisplayed(){
        return continueButton.isDisplayed();
    }
}
