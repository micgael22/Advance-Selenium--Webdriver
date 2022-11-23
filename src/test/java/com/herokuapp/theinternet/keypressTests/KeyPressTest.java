package com.herokuapp.theinternet.keypressTests;

import com.herokuapp.theInternet.base.TestUtilities;
import com.herokuapp.theInternet.pages.KeyPressPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressTest extends TestUtilities {

    @Test
    public void pressKeyTest() {
        log.info("Starting pressKeyTest");

        // open KeyPressPage
        KeyPressPage keyPressP = new KeyPressPage(driver, log);
        keyPressP.openPage();

        // Push keyboard key
        keyPressP.pressKey(Keys.ENTER);

        // Get Results text
        String result = keyPressP.getResultText();

        // Verify Result text is expected
        Assert.assertTrue(result.equals("You entered: ENTER"),
                "result is not expected. \nShould be 'You entered: ENTER', but it is '" + result + "'");
    }

    @Test
    public void pressKeyWithActionsTest() {
        log.info("Starting pressKeyWithActionsTest");

        // open KeyPressPage
        KeyPressPage keyPressP = new KeyPressPage(driver, log);
        keyPressP.openPage();

        // Push keyboard key
        keyPressP.pressKeyWithActions(Keys.SPACE);

        // Get Results text
        String result = keyPressP.getResultText();

        // Verify Result text is expected
        Assert.assertTrue(result.equals("You entered: SPACE"),
                "result is not expected. \nShould be 'You entered: ENTER', but it is '" + result + "'");

    }
}
