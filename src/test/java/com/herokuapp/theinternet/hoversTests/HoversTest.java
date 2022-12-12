package com.herokuapp.theinternet.hoversTests;


import com.herokuapp.theInternet.base.TestUtilities;
import com.herokuapp.theInternet.pages.HoversPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoversTest extends TestUtilities {

    @Test
    public void user2ProfileTest() {
        log.info("Starting user2ProfileTest");

        // Open HoversPage
        HoversPage hoversP = new HoversPage(driver, log);
        hoversP.openPage();

        // Open User 2 profile
        hoversP.openUserProfile(2);

        // Verify correct user profile opened
        Assert.assertTrue(hoversP.getCurrentUrl().contains("/users/2"),
                "Url of opened page is not expected User 1 page url");
    }
}
