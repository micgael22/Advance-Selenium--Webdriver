package com.herokuapp.theInternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowPage01 extends BasePageObject{

    private By clickHereLinkLocator = By.linkText("Click Here");

    public WindowPage01(WebDriver driver, Logger log) {
        super(driver, log);
    }

    // Click 'Click Here' link to open new window
    public void openNewWindow() {
        log.info("Clicking 'Click Here' link");
        click(clickHereLinkLocator);
    }

    // Find page with title "New Window" and switch to it
    public WindowPage02 switchToNewWindowPage() {
        log.info("Looking for 'New Window' page");
        switchToWindowWithTitle("New Window");
        return new WindowPage02(driver, log);
    }
}
