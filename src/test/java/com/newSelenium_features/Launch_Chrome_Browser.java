package com.newSelenium_features;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManager;

public class Launch_Chrome_Browser

{
    private static WebDriver driver;

    public static void main(String[] args) {

//        driver = new ChromeDriver();
//        driver.get("https://www.google.com");
//        driver.manage().window().maximize();
//        System.out.println(driver.getTitle());
//
        //Suppose if we want to open a specific Browser version - named 116 - that is Chrome for testing Browser
        //If we want to specify the Browser version - we can do it with the help of ChromeOptions class
        //At the following location all the drivers will get downloaded - C:\Users\ACER\.cache\selenium

        ChromeOptions co = new ChromeOptions();
        co.setBrowserVersion("116") ;
        //to get the browser path and the driver path of the browser
        String browser_path =  SeleniumManager.getInstance().getDriverPath(co, false).getBrowserPath();
        String driver_path  =  SeleniumManager.getInstance().getDriverPath(co, false).getDriverPath() ;

        System.out.println ("Driver  Path :" + driver_path);
        System.out.println ("Browser Path :" + browser_path) ;

        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

    }
}
