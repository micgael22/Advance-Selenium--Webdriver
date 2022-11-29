package com.herokuapp.theinternet.jsErrorTests;

import com.herokuapp.theInternet.base.TestUtilities;
import com.herokuapp.theInternet.pages.JSErrorPage;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class JSErrorTest extends TestUtilities {

    @Test
    public void jsErrorTest() {
        log.info("Starting jsErrorTest");
        SoftAssert softAssert = new SoftAssert();

        // Open JSErrorPage
        JSErrorPage jSErrorPage = new JSErrorPage(driver, log);
        jSErrorPage.openPage();

        // Get logs
        List<LogEntry> logs = getBrowserLogs();

        // Verifying there are no JavaScript errors in console
        for (LogEntry logEntry : logs) {
            if (logEntry.getLevel().toString().equals("SEVERE")) {
                softAssert.fail("Severe error: " + logEntry.getMessage());
            }
        }
        softAssert.assertAll();
    }
}
