package com.stv.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyAccountPage extends FactoryPage {

    @FindBy(className = "bem-header--2")
    private WebElement greetingLabel;

    @FindBy(id = "btnSignOut")
    private WebElement signOutButton;

    public String getFirstNameInfoFromGreetingLabel() {
        String firstName = "NO_MATCH";
        Pattern r = Pattern.compile("(?<=Welcome\\s)(.*?)(?= )");
        Matcher m = r.matcher(greetingLabel.getText());

        if (m.find()) {
            firstName = m.group();
        }
        return firstName;
    }

    public void clickSignOutButton(){
        signOutButton.click();
    }
}
