package com.driver_manager;

import org.openqa.selenium.WebDriver;

public interface DriverManager <T extends WebDriver> {

    public T createDriver(BrowserType browsetype ) ;
}
