package com.herokuapp.theInternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject {

    private String pageUrl = "http://the-internet.herokuapp.com/";
    private By formAuthenticationLinkLocator = new By.ByLinkText("Form Authentication");
    private By checkboxesLinkLocator = By.linkText("Checkboxes");
    private By dropdownLinkLocator = By.linkText("Dropdown");
    private By javaScriptAlertsLinkLocator = By.linkText("JavaScript Alerts");
    private By multipleWindowsLinkLocator = By.linkText("Multiple Windows");

    public WelcomePageObject(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //Open WelcomePage with it's url
    public void openPage() {
        log.info("Opening Page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
    }

    //Open LoginPage by Clicking on Form Authentication Link
    public LoginPage clickFormAuthenticationLink() {
        log.info("Clicking Form Authentication link on Welcome Page");
        click(formAuthenticationLinkLocator);
        return new LoginPage(driver, log);
    }

    //Open CheckboxesPage by clicking on Checkboxes link
    public CheckBoxesPage clickCheckboxes() {
        log.info("Clicking Checkboxes link on Welcome Page");
        click(checkboxesLinkLocator);
        return new CheckBoxesPage(driver, log);
    }

    //open DropDownPage by clicking on
    public DropDownPage clickDropDownLink() {
        log.info("Clicking Dropdown link on Welcome Page");
        click(dropdownLinkLocator);
        return new DropDownPage(driver, log);
    }

    //open JS-Alerts by clicking on
    public JavaScriptAlertsPage clickJavaScriptAlertsLink() {
        log.info("Clicking JavaScript Alerts link on Welcome Page");
        click(javaScriptAlertsLinkLocator);
        return new JavaScriptAlertsPage(driver, log);
    }

    //open window new window tab by clicking on
    public WindowsPage01 clickMultipleWindowsLink() {
        log.info("Clicking Multiple Windows link on Welcome Page");
        click(multipleWindowsLinkLocator);
        return new WindowsPage01(driver, log);
    }
}
