package com.herokuapp.theinternet.windowsTests;

import com.herokuapp.theInternet.base.TestUtilities;
import com.herokuapp.theInternet.pages.WelcomePage;
import com.herokuapp.theInternet.pages.WindowPage01;
import com.herokuapp.theInternet.pages.WindowPage02;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowsTests extends TestUtilities {

    @Test
    public void newWindowTest() throws InterruptedException {
        log.info("Starting newWindowTest");

        // open main page
        WelcomePage welcomeP = new WelcomePage(driver, log);
        welcomeP.openPage();

        // Click on MultipleWindows link
        WindowPage01 windowsP01= welcomeP.clickMultipleWindowsLink();

        // Click 'Click Here' link to open new window
        windowsP01.openNewWindow();
        sleep(1000);

        // Find and switch to new window page
        WindowPage02 newWindowPage = windowsP01.switchToNewWindowPage();

        String pageSource = newWindowPage.getCurrentPageSource();

        // Verification that new page contains expected text in source
        Assert.assertTrue(pageSource.contains("New Window"), "New page source doesn't contain expected text");
    }

}
