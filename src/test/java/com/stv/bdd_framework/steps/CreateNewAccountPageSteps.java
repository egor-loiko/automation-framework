package com.stv.bdd_framework.steps;

import com.stv.factory.factorypages.CreateNewAccountPage;
import com.stv.factory.factorytests.BasicFactoryTest;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CreateNewAccountPageSteps extends BasicFactoryTest {
    CreateNewAccountPage createNewAccountPage = new CreateNewAccountPage();

    @Then("Create New Account page is opened")
    public void createNewAccountPageIsOpened(){
        Assert.assertEquals(createNewAccountPage.isContinueButtonDisplayed(), true, "Page is not loaded");
    }

}
