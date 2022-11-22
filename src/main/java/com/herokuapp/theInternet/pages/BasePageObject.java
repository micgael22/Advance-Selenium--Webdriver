package com.herokuapp.theInternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BasePageObject {

    protected WebDriver driver;
    protected Logger log;

    public BasePageObject(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

    //Open Page with given url
    protected void openUrl(String url) {
        driver.get(url);
    }

    //Find elements using given locator
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    //Find all elements using given locator
    protected List<WebElement> findAll (By locator) {
        return driver.findElements(locator);
    }

    //Click on element with given locator when its visible
    protected void click(By locator) {
        waitForVisibilityOf( locator, Duration.ofSeconds(10));
        find(locator).click();
    }

    //Type given text into element with given locator
    protected void type(String text, By locator) {
        waitForVisibilityOf(locator, Duration.ofSeconds(10));
        find(locator).sendKeys(text);
    }

    //Get url from current page from browser
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    //Wait for specific ExpectedCondition for the given amount of time in secs
    protected void waitFor(ExpectedCondition<WebElement> condition, Duration timeOut) {
        timeOut = timeOut != null ? timeOut : Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(condition);
    }

    //Get source of current page
    public String getCurrentPageSource() {
        return driver.getPageSource();
    }


    //Wait for given number of seconds for element with given locator to be visible on the page
    protected void waitForVisibilityOf(By locator, Duration... timeOut) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        (timeOut.length > 0 ? timeOut[0] : null));
                break;
            }
            catch (StaleElementReferenceException e) {
            }
            attempts ++;
        }
    }

    // Wait for alert present and then switch to it
    protected Alert switchToAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    //Get title of current page
    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    //Switch to window with title
    public void switchToWindowWithTitle(String expectedTitle) {
        // Switching to new window
        String firstWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> windowsIterator = allWindows.iterator();

        while (windowsIterator.hasNext()) {
            String windowHandle = windowsIterator.next().toString();
            if (!windowHandle.equals(firstWindow)) {
                driver.switchTo().window(windowHandle);
                if (getCurrentPageTitle().equals(expectedTitle)) {
                    break;
                }
            }
        }
    }
}
