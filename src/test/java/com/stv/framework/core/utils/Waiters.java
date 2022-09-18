package com.stv.framework.core.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Waiters {

    public static void waitForElementVisible(WebDriver driver, long timeout, WebElement webElement) {
        new WebDriverWait(driver, Duration.ofMillis(timeout)).pollingEvery(Duration.ofMillis(2000)).until(ExpectedConditions.visibilityOf(webElement));
    }
}
