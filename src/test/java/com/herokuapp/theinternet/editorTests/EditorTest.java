package com.herokuapp.theinternet.editorTests;

import com.herokuapp.theInternet.base.TestUtilities;
import com.herokuapp.theInternet.pages.EditorPage;
import com.herokuapp.theInternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditorTest extends TestUtilities {

    @Test
    public void defaultEditorValueTest() {
        log.info("Starting defaultEditorValueTest");

        // open main page
        WelcomePageObject welcomeP = new WelcomePageObject(driver, log);
        welcomeP.openPage();

        // Click on WYSIWYG Editor link
        EditorPage editorPage = welcomeP.clickWYSIWYGEditorLink();

        // Get default editor text
        String editorText = editorPage.getEditorText();

        // Verification that new page contains expected text in source
        Assert.assertTrue(editorText.equals("Your content goes here."),
                "Editor default text is not expected. It is: " + editorText);
    }
}
