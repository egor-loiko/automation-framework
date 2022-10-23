package com.stv.bdd_framework.steps;

import com.stv.factory.factorypages.MyAccountPage;
import com.stv.factory.factorytests.BasicFactoryTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class MyAccountPageSteps extends BasicFactoryTest {
    MyAccountPage myAccountPage = new MyAccountPage();

    @Then("Page Account is opened")
    public void pageAccountIsOpened() {
        Assert.assertEquals(myAccountPage.getFirstNameInfoFromGreetingLabel(), "First_Name", "Name is not correct");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.wiggle.co.uk/secure/account", "Page is not correct");
    }

    @And("Logout")
    public void logout() {
        myAccountPage.clickSignOutButton();
    }

}
