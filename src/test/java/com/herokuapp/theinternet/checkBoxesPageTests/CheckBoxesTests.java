package com.herokuapp.theinternet.checkBoxesPageTests;

import com.herokuapp.theInternet.base.TestUtilities;
import com.herokuapp.theInternet.pages.CheckBoxesPage;
import com.herokuapp.theInternet.pages.WelcomePageObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxesTests extends TestUtilities {


    @Test
    public void selectingTwoCheckBoxesTest() {
        log.info("Starting selectingTwoCheckboxes");

        //open main page
        WelcomePageObject welcomeP = new WelcomePageObject(driver, log);
        welcomeP.openPage();

        //Click in checkboxes link
        CheckBoxesPage checkBoxesPage = welcomeP.clickCheckboxes();

        //Select all Checkboxes
        checkBoxesPage.selectAllCheckboxes();

        //Verify all Checkboxes
        Assert.assertTrue(checkBoxesPage.areAllCheckboxesChecked(),
                "Not all checkboxes are checked ");
    }

}
