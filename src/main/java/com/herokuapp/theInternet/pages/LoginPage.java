package com.herokuapp.theInternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject{

    private By userNameLocator = By.id("username");
    private By passwordLocator = By.name("password");
    private By loginButtonLocator = By.tagName("button");

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //Execute log in
    public SecureAreaPage logIn (String username, String password) {
        log.info("Executing LogIn with username [" + username + "] and password [" + password + "]");
        type(username, userNameLocator);
        type(password, passwordLocator);
        click(loginButtonLocator);
        return new SecureAreaPage(driver, log);
    }
}
