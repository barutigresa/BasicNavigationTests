package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com", "https://www.westelm.com", "https://walmart.com");

        for(int i =0 ; i < urls.size(); i++)
        {
            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get(urls.get(i));
            if(urls.get(i).toLowerCase().contains(driver.getTitle().replace(" ", "").toLowerCase()))
            {
                System.out.println(driver.getTitle() + " PASSED");
                System.out.println(driver.getCurrentUrl());
            }
            else
            {
                System.out.println(driver.getTitle() + " FAILED");
                System.out.println(urls.get(i));
            }
            driver.close();
        }

    }
}
