package com.herokuapp.theInternet.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;
    @Parameters({ "browser" })
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {

        System.out.println("ON SETUP -------------------------->");
        BrowserDriverFactory factory = new BrowserDriverFactory(browser);
        driver = factory.createDriver();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.manage().window().maximize();
        System.out.println("SETUP DONE-------------------------->");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println("Close driver");
        // Close browser
        driver.quit();
    }
}
