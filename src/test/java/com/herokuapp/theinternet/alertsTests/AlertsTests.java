package com.herokuapp.theinternet.alertsTests;

import com.herokuapp.theInternet.base.TestUtilities;
import com.herokuapp.theInternet.pages.JavaScriptAlertsPage;
import com.herokuapp.theInternet.pages.WelcomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AlertsTests extends TestUtilities {

    @Test
    public void jsAlertTest() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        // open main page
        WelcomePage welcomeP = new WelcomePage(driver, log);
        welcomeP.openPage();

        // Click on JavaScript Alerts link
        JavaScriptAlertsPage alertsP = welcomeP.clickJavaScriptAlertsLink();

        // Click JS Alert button
        alertsP .openJSAlert();
        sleep(1000);

        // Get alert text
        String alertMsg = alertsP.getAlertText();

        // Click OK button
        alertsP.acceptAlert();

        // Get Results text
        String result = alertsP.getResultText();
        sleep(1000);

        //Verifications
        //1 - Alert text is expected
        softAssert.assertTrue(alertMsg.equals("I am a JS Alert"),
                "Alert message is not expected. \nShould be 'I am a JS Alert', but it is '" + alertMsg + "'");

        //2 - Result text is expected
        softAssert.assertTrue(result.equals("You successfuly clicked an alert"),
                "result is not expected. \nShould be 'You successfuly clicked an alert', but it is '" + result + "'");

        softAssert.assertAll();
    }

    @Test
    public void jsDismissTest() throws InterruptedException{
        SoftAssert softAssert = new SoftAssert();

        // open main page
        WelcomePage welcomeP = new WelcomePage(driver, log);
        welcomeP.openPage();

        // Click on JavaScript Alerts link
        JavaScriptAlertsPage alertsP = welcomeP.clickJavaScriptAlertsLink();

        // Click JS Confirm button
        alertsP.openJSConfirm();
        sleep(1000);

        // Get alert text
        String alertMsg = alertsP.getAlertText();

        // Click Cancel button
        alertsP.dismissAlert();

        // Get Results text
        String result = alertsP.getResultText();
        sleep(1000);

        // Verifications
        // 1 - Alert text is expected
        softAssert.assertTrue(alertMsg.equals("I am a JS Confirm"),
                "Alert message is not expected. \nShould be 'I am a JS Confirm', but it is '" + alertMsg + "'");

        // 2 - Result text is expected
        softAssert.assertTrue(result.equals("You clicked: Cancel"),
                "result is not expected. \nShould be 'You clicked: Cancel', but it is '" + result + "'");

        softAssert.assertAll();
    }

    @Test
    public void jsPromptTest() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        // open main page
        WelcomePage welcomeP = new WelcomePage(driver, log);
        welcomeP.openPage();

        // Click on JavaScript Alerts link
        JavaScriptAlertsPage alertsP = welcomeP.clickJavaScriptAlertsLink();

        // Click JS Prompt button
        alertsP.openJSPrompt();
        sleep(1000);

        // Get alert text
        String alertMsg = alertsP.getAlertText();

        // Type text into alert
        alertsP.typeTextIntoAlert("Hello Alert, it's Micgael here");
        sleep(1000);
        // Get Results text
        String result = alertsP.getResultText();
        sleep(1000);

        // Verifications
        // 1 - Alert text is expected
        softAssert.assertTrue(alertMsg.equals("I am a JS prompt"),
                "Alert message is not expected. \nShould be 'I am a JS prompt', but it is '" + alertMsg + "'");

        // 2 - Result text is expected
        softAssert.assertTrue(result.equals("You entered: Hello Alert, it's Micgael here"),
                "result is not expected. \nShould be 'You entered: Hello Alert, its Dmitry here', but it is '"
                        + result + "'");

        softAssert.assertAll();
    }
}
