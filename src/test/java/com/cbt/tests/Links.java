package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Links {
    public static void linksTest() {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.w3schools.com/");

        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            if (link.isDisplayed()) {
                System.out.println(link.getText()+" with link "+link.getAttribute("href"));
            }
        }
    }

    public static void main(String[] args) {
        linksTest();
    }
}
