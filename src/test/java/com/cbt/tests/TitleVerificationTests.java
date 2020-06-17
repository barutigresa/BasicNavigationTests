package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TitleVerificationTests {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");
        String titles[] = new String[3];
        WebDriver driver = BrowserFactory.getDriver("chrome");
        for(int i =0 ; i < urls.size(); i++)
        {
            driver.get(urls.get(i));
            titles[i] = driver.getTitle();
        }
        if(titles[0].equals(titles[1]) && titles[0].equals(titles[2]))
        {
            System.out.println("Titles are the same");
        }
        else
        {
            System.out.println("Titles are no the same");
        }
        if(urls.get(0).startsWith("http://practice.cybertekschool.com") && urls.get(1).startsWith("http://practice.cybertekschool.com") && urls.get(2).startsWith("http://practice.cybertekschool.com"))
        {
            System.out.println("All pages start with http://practice.cybertekschool.com");
        }
        else {
            System.out.println("Pages don't start with http://practice.cybertekschool.com");
        }
        driver.close();
    }
}
