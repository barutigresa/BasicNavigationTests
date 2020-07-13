package com.cbt.tests;
import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Departments {
    public static void departmentsTest() {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");


        Select departments = new Select(driver.findElement(By.id("searchDropdownBox")));
        List<WebElement> options = departments.getOptions();

        for (int i = 1; i < options.size() - 1; i++) {
            String current = options.get(i).getText();
            String next = options.get(i + 1).getText();
            System.out.println("Comparing: " + current + " " + next);
            if (current.compareTo(next) < 0) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL");
            }
        }
    }

    public static void main(String[] args) {
        departmentsTest();
    }
}