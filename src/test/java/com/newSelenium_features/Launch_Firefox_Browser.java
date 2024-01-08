package com.newSelenium_features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Launch_Firefox_Browser {

    private static WebDriver driver ;
 public static void main(String[] args) {

        //Firefox available in system - 120 .0 version
        //With the help of SeleniumManager - we can easily download the latest version of Firefox
        //if we dont specify any browser version, it will directly download the driver version which is available in system
//        driver = new FirefoxDriver() ;
//        driver.get("https://www.google.com");
//        driver.manage().window().maximize();
//        System.out.println(driver.getTitle());

        //suppose if we want to run the same code in specific - or some old firefox version
        //then we need to specify the version of the firefox browser

//        FirefoxOptions opt = new FirefoxOptions();
//        opt.setBrowserVersion("117") ;//any version - older or newer version which we can download in system
//        //pass the opt object
//        driver = new FirefoxDriver(opt) ;
//        driver.get("https://www.google.com");
//        driver.manage().window().maximize();
//        System.out.println(driver.getTitle());

        //to launch the nightly build of the firefox version - where we can launch the updated version of the firefox browser
       FirefoxOptions opt = new FirefoxOptions();
       opt.setBrowserVersion("nightly") ;//similaryl we cab check for dev ,build and beta version
       //pass the opt object
       driver = new FirefoxDriver(opt) ;
       driver.get("https://www.google.com");
       driver.manage().window().maximize();
       System.out.println(driver.getTitle());

      //At the following path the driver path will get stored :-
     //C:\Users\ACER\.cache\selenium\firefox\win64\122.0a1
    }
}
