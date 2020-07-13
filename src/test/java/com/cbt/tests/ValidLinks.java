package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ValidLinks {
    public static void linksTest2() {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.selenium.dev/documentation/en/");

        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (int i = 0; i < links.size(); i++) {
            String href = links.get(i).getAttribute("href");

            try {
                if (href.startsWith("https://") && (href.contains(".com") || href.contains(".dev"))) {
                    System.out.println("PASS - link: " + href + " is valid");
                } else {
                    System.out.println("FAIL - link: " + href + " is not valid");
                }
            } catch(NullPointerException e){
                System.out.println("This is not a link");
            }
        }
    }

    public static void main(String[] args) {
        linksTest2();
    }
}
