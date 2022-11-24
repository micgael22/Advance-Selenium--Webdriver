package com.herokuapp.theinternet.loginTest;

import com.herokuapp.theInternet.base.TestUtilities;
import com.herokuapp.theInternet.pages.LoginPage;
import com.herokuapp.theInternet.pages.SecureAreaPage;
import com.herokuapp.theInternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PositiveLoginTests extends TestUtilities {

	@Test
	public void logInTest() throws InterruptedException {
		System.out.println("STARTING POSITIVE LOGIN TEST ---------------------------------->");

		log.info("Starting login test");

		// open main page
		WelcomePage welcomeP = new WelcomePage(driver, log);
		welcomeP.openPage();

		// Click on Form Authentication link
		LoginPage loginP = welcomeP.clickFormAuthenticationLink();

		//execute logIn
		SecureAreaPage secureAreaP = loginP.logIn("tomsmith", "SuperSecretPassword!");

		// verifications
		// new page url is expected
		Assert.assertEquals(secureAreaP.getCurrentUrl(), secureAreaP.getPageUrl());

		// log out button is visible
		Assert.assertTrue(secureAreaP.isLogOutButtonVisible(), "LogOut Button is not Visible");

		// Successful log in message
		String expectedSuccessMessage = "You logged into a secure area!";
		String actualSuccessMessage = secureAreaP.getSuccessMessageText();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);

		System.out.println("ENDING POSITIVE LOGIN TEST ---------------------------------->");
	}
}
