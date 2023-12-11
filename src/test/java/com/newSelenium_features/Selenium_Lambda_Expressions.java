package com.newSelenium_features;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Selenium_Lambda_Expressions  {


    static WebDriver driver ;

    public static void main(String[] args) {

        driver = new ChromeDriver() ;

        driver.get("https://www.amazon.in/");

        driver.manage().window().maximize();

        List<WebElement> all_link =  driver.findElements(By.tagName("a"));

        //directly using the forEach  -consumer Interface
        //all_link.forEach(ele -> System.out.println (ele.getText()));

        System.out.println ("---------------------Alternative way using Stream -----------------------");

        //to print the text of all the WebElements - > to print the text -> alternate way
        //all_link.stream().map(ele -> ele.getText()).forEach(x -> System.out.println (x));

        //to print the text of all the WebElements - > to print the text -> alternate way and ignore the blank values
        System.out.println ("---------------------Alternative way using Stream and ignoring the blank values  -----------------------");

        List<String> all_links_02 = all_link.stream().
                filter(ele -> !ele.getText().equals(""))//ignore the blank values
                .map(ele -> ele.getText())//perform the operation
                .collect(Collectors.toList());//collect the elements inside the list
        //all_links_02.forEach(System.out:: println );

        System.out.println ("---------------------Fetch the first and any Element -----------------------");

        //find the first element
        String text_element_first = all_link.parallelStream().filter(ele -> !ele.getText().equals("")).
                findFirst().get().getText();
        System.out.println ("fetch the first element :" + text_element_first);

        //find any element
        String text_element_any = all_link.parallelStream().filter(ele -> !ele.getText().equals("")).
                findAny().get().getText();

        System.out.println ("fetch any element :" + text_element_any);
        System.out.println ("all links size :" + all_link.size());

        //exclude blank and the link which starts with Amazon

        List<String> all_links_03 = all_link.stream()
                .filter(ele -> !ele.getText().equals("") && ele.getText().startsWith("Amaz"))
                .map(ele -> ele.getText())
                .collect(Collectors.toList());

        all_links_03.forEach(System.out:: println);

        System.out.println ("-----------------Ignore all the blank spaces and empty text and spaces  -----------------------");

        List<String> all_links_04 = all_link.stream()
                .filter(ele -> ! ele.getText().equals(""))
                .filter(ele -> ! ele.getText().startsWith(" "))
                .map(ele -> ele.getText().trim())
                .collect(Collectors.toList());

        all_links_04.forEach(x -> System.out.println(x));


        driver.quit();

    }

}
