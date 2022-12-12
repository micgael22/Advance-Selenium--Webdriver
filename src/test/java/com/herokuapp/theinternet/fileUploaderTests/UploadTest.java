package com.herokuapp.theinternet.fileUploaderTests;

import com.herokuapp.theInternet.base.TestUtilities;
import com.herokuapp.theInternet.pages.FileUploaderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadTest extends TestUtilities {

    @Test(dataProvider = "files")
    public void fileUploadTest(int no, String fileName) {
        log.info("Starting fileUploadTest #" + no + " for " + fileName);

        // open File Uploader Page
        FileUploaderPage fileUploaderP = new FileUploaderPage(driver, log);
        fileUploaderP.openPage();

        // Select file
//        String fileName = "logo.png";
        fileUploaderP.selectFile(fileName);

        // Push upload button
        fileUploaderP.pushUploadButton();

        // Get uploaded files
        String fileNames = fileUploaderP.getUploadedFilesNames();

        // Verify selected file uploaded
        Assert.assertTrue(fileNames.contains(fileName),
                "Our file (" + fileName + ") is not one of the uploaded (" + fileNames + ")");
    }
}
