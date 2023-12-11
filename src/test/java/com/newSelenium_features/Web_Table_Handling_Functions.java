package com.newSelenium_features ;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;



public class Web_Table_Handling_Functions  {
    static WebDriver driver;

    public static void main(String[] args) {

        driver = new EdgeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.w3schools.com/html/html_tables.asp");

        String rowcount_xpath = "//table[@id = 'customers']/tbody/tr";
        String colcount_xpath = "//table[@id = 'customers']/tbody/tr/th";

        //call the method
        System.out.println (getRowColNuber("Roland Mendel", rowcount_xpath, colcount_xpath));

    }

    public static boolean getRowColNuber (String name , String rowcount_xpath, String colcount_xpath) {

        // get the rowCOunt and Col count
        int rowcount = driver.findElements(By.xpath(rowcount_xpath)).size();
        int colCount = driver.findElements(By.xpath(colcount_xpath)).size();

        boolean flag = false;

        for (int i = 1; i < rowcount; i++) {

            for (int j = 1; j <= colCount; j++) {

                // here the i signifies the rowCount and j signifies the colCount
                String col_text = driver.findElement(By.xpath("//table[@id = 'customers']/tbody/tr[" + (i + 1) + "]/td[" + j + "]"))
                        .getText();

                if (col_text.equalsIgnoreCase(name)) {
                    flag = true;
                    System.out.println("Row value :" + i + " " + "Column value :" + " " + j);
                    // break the loop
                    break;
                }
            }
        }
        if (flag) {
            return true;
        }
        return flag;
    }
}


