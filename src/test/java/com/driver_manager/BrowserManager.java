package com.driver_manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserManager implements DriverManager {


    @Override
    public WebDriver createDriver(BrowserType browsetype) {

        switch(browsetype) {
            case CHROME :
                return new ChromeDriver() ;

            case EDGE :
                return new EdgeDriver() ;

            default:
                throw new IllegalArgumentException("Invalid Browser Type :");
        }
    }

    public static void main(String[] args) {

        //create the object of the Class for launching Chrome Browser
        BrowserManager browserobj = new BrowserManager() ;
        WebDriver driver_chrome = browserobj.createDriver(BrowserType.CHROME) ;
        driver_chrome.get("https://www.google.com");
        driver_chrome.manage().window().maximize() ;
        driver_chrome.close();

        //create the object of the Class for launching Edge Browser
        BrowserManager browserobj_edge = new BrowserManager() ;
        WebDriver driver_edge = browserobj_edge.createDriver(BrowserType.EDGE) ;
        driver_edge.get("https://www.google.com");
        driver_edge.manage().window().maximize() ;
        driver_edge.close();




    }

}
