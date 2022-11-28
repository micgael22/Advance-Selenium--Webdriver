package com.herokuapp.theinternet.loginTest;

import com.herokuapp.theInternet.base.CsvDataProviders;
import com.herokuapp.theInternet.base.TestUtilities;
import com.herokuapp.theInternet.pages.LoginPage;
import com.herokuapp.theInternet.pages.WelcomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Map;

public class NegativeLoginTests extends TestUtilities {

	@Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void negativeLoginTest(Map<String, String> testData) {

		// Data
		String no = testData.get("no");
		String username  = testData.get("username");
		String password = testData.get("password");
		String expectedErrorMessage = testData.get("expectedMessage");
		String description = testData.get("description");

		log.info("Starting negativeLogInTest #" + no + " for " + description);

		WelcomePage welcomeP = new WelcomePage(driver, log);
		welcomeP.openPage();

		// Click on Form Authentication link
		LoginPage loginP = welcomeP.clickFormAuthenticationLink();

		//execute negative logIn
		loginP.negativeLogIn(username, password);

		//wait for error message
		loginP.waitForErrorMessage();
		String message = loginP.getErrorMessageText();

		// Verification
		Assert.assertTrue(message.contains(expectedErrorMessage), "Message doesn't contain expected text.");

		System.out.println("ENDING NEGATIVE LOGIN TEST ---------------------------------->");
	}
}
