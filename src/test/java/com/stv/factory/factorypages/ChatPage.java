package com.stv.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChatPage extends FactoryPage{

    @FindBy(id = "eGainChatImage")
    private WebElement openChatIcon;

    @FindBy(id = "header-message")
    private WebElement chatHeader;

    @FindBy(xpath = "//button[contains(text(),'Start Chat')]")
    private WebElement startChatButton;

    @FindBy(id = "full_name")
    private WebElement nameField;

    @FindBy(xpath = "//label[contains(text(),'Name is required')]")
    private WebElement nameIsRequiredValidation;

    @FindBy(xpath = "//label[contains(text(),'Email is required')]")
    private WebElement emailIsRequiredValidation;

    @FindBy(xpath = "//label[contains(text(),'Your Question is required')]")
    private WebElement questionIsRequiredValidation;

    @FindBy(id = "chat-close-btn")
    private WebElement chatCloseButton;

    public void clickOpenChatIcon(){
        openChatIcon.click();
    }

    public boolean isOpenChatIconDisplyed(){
        return openChatIcon.isDisplayed();
    }

    public boolean isChatHeaderIdDisplayed(){
        return chatHeader.isDisplayed();
    }

    public void clickStartChatbutton(){
        startChatButton.click();
    }

    public void enterDataToNameField(String name){
        nameField.sendKeys(name);
    }

    public boolean isNameRequiredMessageShown(){
        return nameIsRequiredValidation.isDisplayed();
    }

    public boolean isEmailRequiredMessageShown(){
        return emailIsRequiredValidation.isDisplayed();
    }

    public boolean isQuestionRequiredMessageShown(){
        return questionIsRequiredValidation.isDisplayed();
    }

    public void closeChat(){
        chatCloseButton.click();
    }
}
