package com.stv.bdd_framework.steps;

import com.stv.factory.factorypages.MainFactoryPage;
import com.stv.factory.factorytests.BasicFactoryTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import java.time.Duration;
import static com.stv.framework.core.lib.WigglePageURLs.START_URL;

public class MainPageSteps extends BasicFactoryTest {
    MainFactoryPage mainFactoryPage = new MainFactoryPage();
    JavascriptExecutor js = (JavascriptExecutor) getDriver();

    @Given("Main page is loaded")
    public void navigationToMainPage() {
        getDriver().manage().deleteAllCookies();
        getDriver().get(START_URL);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        getDriver().manage().window().maximize();
        mainFactoryPage.isAccountLinkDisplayed();
        mainFactoryPage.clickOnTrustButton();
    }

    @And("Navigate to Login page")
    public void navigateToLoginPage() {
        mainFactoryPage.clickOnAccountLink();
    }

    @And("Open Help Pages Link")
    public void openHelpPagesLink() throws InterruptedException {
        mainFactoryPage.clickHelpPagesLink();
    }

    @Then("Wiggle Customer Services page is opened")
    public void wiggleCustomerServicesIsOpened() {
        Assert.assertTrue(mainFactoryPage.isWelcomeCustomerServiceDisplayed());
    }

    @And("Return to Home Page")
    public void returnToHomePage() {
        mainFactoryPage.clickOnWiggleLogoLink();
    }


    @And("Scroll down Home Page")
    public void scrollDownHomePage() {
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
}