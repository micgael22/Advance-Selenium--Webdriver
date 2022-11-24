package com.herokuapp.theinternet.dragDropTests;

import com.herokuapp.theInternet.base.TestUtilities;
import com.herokuapp.theInternet.pages.DragDropPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragDropTest extends TestUtilities {

    @Test
    public void dragAToBTest() throws InterruptedException {
        log.info("Starting dragAToBTest");

        // Open DragAndDropPage
        DragDropPage dragDropP = new DragDropPage(driver, log);
        dragDropP.openPage();

        // Drag box A and drop it on box B
        sleep(5000);
        dragDropP.dragAtoB();
        sleep(5000);

        // Verify correct headers in correct boxes
        String columnAText = dragDropP.getColumnAText();
        Assert.assertTrue(columnAText.equals("B"), "Column A header should be B, but it is: " + columnAText);

        String columnBText = dragDropP.getColumnBText();
        Assert.assertTrue(columnBText.equals("A"), "Column A header should be B, but it is: " + columnBText);
    }
}
