package com.herokuapp.theinternet.editorTests;

import com.herokuapp.theInternet.base.TestUtilities;
import com.herokuapp.theInternet.pages.EditorPage;
import com.herokuapp.theInternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditorTest extends TestUtilities {

    @Test
    public void defaultEditorValueTest() throws InterruptedException {
        log.info("Starting defaultEditorValueTest");

        // open main page
        WelcomePage welcomeP = new WelcomePage(driver, log);
        welcomeP.openPage();

        //Scroll to the bottom
        sleep(5000);
        welcomeP.scrollToBottom();
        sleep(5000);

        // Click on WYSIWYG Editor link
        EditorPage editorPage = welcomeP.clickWYSIWYGEditorLink();

        // Get default editor text
        String editorText = editorPage.getEditorText();

        // Verification that new page contains expected text in source
        Assert.assertTrue(editorText.equals("Your content goes here."),
                "Editor default text is not expected. It is: " + editorText);
    }
}
