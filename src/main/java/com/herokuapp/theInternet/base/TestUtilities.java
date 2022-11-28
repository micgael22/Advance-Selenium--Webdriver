package com.herokuapp.theInternet.base;

import org.testng.annotations.DataProvider;

public class TestUtilities extends BaseTest{

    //STATIC SLEEP
    public void sleep(long millis) throws InterruptedException {

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @DataProvider(name="files")
    protected static Object[][] files() {
        return new Object[][] {
                {1, "index.html"},
                {2, "logo.png"},
                {3, "text.txt"}
        };
    }


}
