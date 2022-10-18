package com.stv.factory.factorytests;

import com.stv.framework.core.drivers.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import static com.stv.framework.core.lib.WigglePageURLs.START_URL;

public class BasicFactoryTest {
    public static WebDriver getDriver() {
        return Driver.getDriver();
    }

    @BeforeClass(description = "Start browser")
    public void setUp() {
        System.out.println("Before class");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        getDriver().manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
        getDriver().get(START_URL);
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
        getDriver().manage().deleteAllCookies();
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
        getDriver().quit();
    }
}
