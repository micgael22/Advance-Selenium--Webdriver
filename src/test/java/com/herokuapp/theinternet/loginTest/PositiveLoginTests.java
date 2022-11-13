package com.herokuapp.theinternet.loginTest;

import com.herokuapp.theInternet.base.TestUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PositiveLoginTests extends TestUtilities {

	@Test
	public void logInTest() throws InterruptedException {
		System.out.println("STARTING POSITIVE LOGIN TEST ---------------------------------->");

		// open main page
		String url = "http://the-internet.herokuapp.com/";
		driver.get(url);
		log.info("Main page is opened.");

		// Click on Form Authentication link
		driver.findElement(By.linkText("Form Authentication")).click();

		// enter username and password
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

//		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		sleep(3000);

		// push log in button
		WebElement logInButton = driver.findElement(By.className("radius"));
		//wait.until(ExpectedConditions.elementToBeClickable(logInButton));
		logInButton.click();

		// verifications
		// new url
		String expectedUrl = "http://the-internet.herokuapp.com/secure";
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

		// log out button is visible
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='button secondary radius']")).isDisplayed(),
				"logOutButton is not visible.");

		// Successful log in message
		String expectedSuccessMessage = "You logged into a secure area!";
		String actualSuccessMessage = driver.findElement(By.id("flash")).getText();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);

		System.out.println("ENDING POSITIVE LOGIN TEST ---------------------------------->");
	}
}
