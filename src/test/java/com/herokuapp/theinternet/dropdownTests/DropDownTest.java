package com.herokuapp.theinternet.dropdownTests;

import com.herokuapp.theInternet.base.TestUtilities;
import com.herokuapp.theInternet.pages.DropDownPage;
import com.herokuapp.theInternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;
public class DropDownTest extends TestUtilities {

    @Test
    public void optionTwoTest()  {
        log.info("Starting optionTwoTest ------->");

        //Open main page
        WelcomePageObject welcomeP = new WelcomePageObject(driver, log);
        welcomeP.openPage();

        //click on Dropdown link
        DropDownPage dropdownP = welcomeP.clickDropDownLink();

        //Select Option 2
        dropdownP.selectOption(2);

        //Verify Option 2 is selected
        String selectedOption = dropdownP.getSelectedOption();
        Assert.assertTrue(selectedOption.equals("Option 2"),
                "option 2 is not selected. Instead selected - "
        + selectedOption);

    }
}
