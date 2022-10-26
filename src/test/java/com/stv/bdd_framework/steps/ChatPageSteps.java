package com.stv.bdd_framework.steps;

import com.stv.factory.factorypages.ChatPage;
import com.stv.factory.factorytests.BasicFactoryTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class ChatPageSteps extends BasicFactoryTest {
    ChatPage chatPage = new ChatPage();

    @And("Open Live Chat")
    public void openChat() {
        chatPage.clickOpenChatIcon();
    }

    @Then("Live Chat is opened")
    public void checkLiveChatIsOpened() {
        chatPage.switchToChatFrame(getDriver());
        Assert.assertTrue(chatPage.isChatHeaderIdDisplayed(), "Live chat is not shown");
    }

    @And("Click Start Chat button")
    public void clickStartChatButton() {
        chatPage.clickStartChatbutton();
    }

    @Then("Validation messages appear")
    public void validationMessagesAppear() {
        Assert.assertTrue(chatPage.isNameRequiredMessageShown());
        Assert.assertTrue(chatPage.isEmailRequiredMessageShown());
        Assert.assertTrue(chatPage.isQuestionRequiredMessageShown());
    }

    @And("Close Live Chat")
    public void closeLiveChat() {
        chatPage.closeChat();
        chatPage.isOpenChatIconDisplyed();
        chatPage.switchToParentFrame(getDriver());
    }
}
