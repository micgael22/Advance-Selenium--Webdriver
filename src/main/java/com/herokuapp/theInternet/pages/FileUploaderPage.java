package com.herokuapp.theInternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploaderPage extends BasePageObject{
    private String pageUrl = "http://the-internet.herokuapp.com/upload";
    private By uploadBLocator = By.id("file-submit");
    private By choseFileLocator = By.id("file-upload");
    private By uploadFilesLocator = By.id("uploaded-files");

    public FileUploaderPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    // Open FileUploaderPage with it's url
    public void openPage() {
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
    }

    // Push Upload button
    public void pushUploadButton() {
        log.info("Clicking on upload button");
        click(uploadBLocator);
    }

    // Push Upload button
    public void selectFile(String fileName) {
        log.info("Selecting '" + fileName + "' file from Files folder");
        // Selecting file
        // String filePath = "path";
        String filePath = System.getProperty("user.dir") + "/src/main/resources/files/" + fileName;
        type(filePath, choseFileLocator);
        log.info("File selected");
    }

    // Get names of uploaded files
    public String getUploadedFilesNames() {
        String names = find(uploadFilesLocator).getText();
        log.info("Uploaded files: " + names);
        return names;
    }


}
