package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {
    public static void chromeTest(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://google.com");
        String t1 = driver.getTitle();
        driver.get("https://etsy.com");
        String t2 = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(t1, driver.getTitle());
        driver.navigate().forward();
        StringUtility.verifyEquals(t2, driver.getTitle());
        driver.close();
    }
    public static void firefoxTest(){
        WebDriver driver = BrowserFactory.getDriver("firefox");
        driver.get("https://google.com");
        String t1 = driver.getTitle();
        driver.get("https://etsy.com");
        String t2 = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(t1, driver.getTitle());
        driver.navigate().forward();
        StringUtility.verifyEquals(t2, driver.getTitle());
        driver.close();
    }
    public static void edgeTest(){
        WebDriver driver = BrowserFactory.getDriver("edge");
        driver.get("https://google.com");
        String t1 = driver.getTitle();
        driver.get("https://etsy.com");
        String t2 = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(t1, driver.getTitle());
        driver.navigate().forward();
        StringUtility.verifyEquals(t2, driver.getTitle());
        driver.close();
    }


    public static void main(String[] args) {
        chromeTest();
        firefoxTest();
        edgeTest();
    }
}
