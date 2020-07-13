package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TodaysDate {
    public static void dateTest(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        Select year = new Select(driver.findElement(By.id("year")));
        Select month = new Select(driver.findElement(By.id("month")));
        Select day = new Select(driver.findElement(By.id("day")));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MMMM/dd");
        LocalDateTime currentDate = LocalDateTime.now();

        StringUtility.verifyEquals(dtf.format(currentDate),year.getFirstSelectedOption().getText() + "/" +
                                                                   month.getFirstSelectedOption().getText() + "/" +
                                                                   day.getFirstSelectedOption().getText());

    }

    public static void main(String[] args) {
        dateTest();
    }
}
