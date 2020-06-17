package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.google.gson.internal.$Gson$Preconditions;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerificiation2 {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com", "https://www.westelm.com", "https://walmart.com");
        WebDriver driver = BrowserFactory.getDriver("chrome");
        for(int i =0 ; i < urls.size(); i++)
        {
            driver.get(urls.get(i));
            if(urls.get(i).toLowerCase().contains(driver.getTitle().replace(" ", "").toLowerCase()))
            {
                System.out.println(driver.getTitle() + " PASSED");
            }
            else
            {
                System.out.println(driver.getTitle() + " FAILED");
                System.out.println(urls.get(i));
            }
        }
        driver.close();
    }
}
