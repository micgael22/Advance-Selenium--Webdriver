package com.herokuapp.theInternet.base;

public class TestUtilities extends BaseTest{

    //STATIC SLEEP
    public void sleep(long millis) throws InterruptedException {

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
