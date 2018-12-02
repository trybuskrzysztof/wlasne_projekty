package com.company;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	    System.out.println("hello");
        System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver_win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        String url = "http://www.store.demoqa.com";
        driver.get(url);

        String title = driver.getTitle();
        int titleLength = driver.getTitle().length();

        System.out.println("Page title = " + title);
        System.out.println("Page title length = " + titleLength);

        // Storing URL in String variable
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(url)){
            System.out.println("Verification Successful - The correct Url is opened.");
        }else{
            System.out.println("Verification Failed - An incorrect Url is opened.");
            //In case of Fail, you like to print the actual and expected URL for the record purpose
            System.out.println("Actual URL is : " + actualUrl);
            System.out.println("Expected URL is : " + url);
        }

        String pageSource = driver.getPageSource();
        int pageSourceLength = driver.getPageSource().length();
        System.out.println("page source length = " + pageSourceLength);

        Thread.sleep(5000);
        driver.close();
    }
}
