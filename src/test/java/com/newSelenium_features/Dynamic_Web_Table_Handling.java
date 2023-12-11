package com.newSelenium_features;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dynamic_Web_Table_Handling {

    static WebDriver driver ;
    static String url = "https://testuserautomation.github.io/WebTable/" ;

    @BeforeTest
    public void setup () {


        driver = new ChromeDriver() ;
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }



    @Test (description = "handling dynamic web table ")
    public void verifywebtable () throws Exception {

        String BeforeXpath = "//table/tbody/tr[" ;
        String AfterXpath = "]/td[2]" ;

        //to get the number of rows
        List <WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr")) ;

        List <WebElement> cols = driver.findElements(By.xpath("//table/tbody/tr/td")) ;

        System.out.println ("Number of rows is :" + rows.size());
        System.out.println ("Number of cols is :" + cols.size()) ;

        for ( int i = 2 ; i <= rows.size() ; i ++ ) {

            String firstname = driver.findElement(By.xpath(BeforeXpath + i + AfterXpath )).getText() ;
            System.out.println ("firstname is :" + firstname);

            if (firstname.contains("Will")) {

                driver.findElement(By.xpath("//table/tbody/tr["+ i +"]/td[1]/input")).click();
                System.out.println ("candidate has been seleced ");
                Thread.sleep(5000);
                break ;
            }


        }

    }


    @AfterTest
    public void closebrowser () {

        driver.close();
    }

}
