package com.herokuapp.theinternet.loginTest;

import com.herokuapp.theInternet.base.TestUtilities;
import com.herokuapp.theInternet.pages.LoginPage;
import com.herokuapp.theInternet.pages.WelcomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class NegativeLoginTests extends TestUtilities {

	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 1)
	public void negativeTest(String username, String password, String expectedErrorMessage) {
		System.out.println("STARTING NEGATIVE LOGIN TEST ---------------------------------->");

		log.info("STARTING NEGATIVE LOGIN TEST");

		// open main page
//		String url = "http://the-internet.herokuapp.com/";
//		driver.get(url);
//		log.info("Main page is opened.");
		// New
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
		String actualErrorMessage = driver.findElement(By.id("flash")).getText();
		Assert.assertTrue(message.contains(expectedErrorMessage), "Message doesn't contain expected text.");

		System.out.println("ENDING NEGATIVE LOGIN TEST ---------------------------------->");
	}
}
