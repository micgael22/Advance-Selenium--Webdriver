import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class FFtest {

    public static void main(String[] args) {

        // Setting system properties of FirefoxDriver
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");

        //Creating an object of FirefoxDriver
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");

        //name locator for text box
        driver.findElement(By.name("q")).sendKeys("Browserstack Guide");

        //name locator for google search
        WebElement searchbutton = driver.findElement(By.name("btnK"));
        searchbutton.click();
        driver.quit();
    }
}
