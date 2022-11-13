package com.herokuapp.theInternet.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;
    protected Logger log;

    @Parameters({ "browser" })
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser, ITestContext ctx) {

        System.out.println("ON SETUP -------------------------->");

        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);

        BrowserDriverFactory factory = new BrowserDriverFactory(browser ,log);
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
        log.info("CLOSE DRIVER ----------------------->");
        // Close browser
        driver.quit();
    }
}
