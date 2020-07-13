package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class MainDepartments {
    public static void headersTest() {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/gp/site-directory");

        Select departments = new Select(driver.findElement(By.id("searchDropdownBox")));
        List<WebElement> depts = departments.getOptions();
        List<String> deptsTxt = new ArrayList<>();

        for (WebElement dept : depts) {
            deptsTxt.add(dept.getText());
        }
        List<WebElement> headers = driver.findElements(By.className("fsdDeptTitle"));

        for (WebElement header : headers) {
            String headerText = header.getText();
            if (deptsTxt.contains(headerText)) {
                System.out.println("PASS: Header: "+headerText+" - is on the dropdown list options.");
            } else {
                System.out.println("FAIL: Header: "+headerText+" - is not on the dropdown list options.");
            }
        }
    }

    public static void main(String[] args) {
        headersTest();
    }
}
