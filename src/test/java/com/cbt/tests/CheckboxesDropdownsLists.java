package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CheckboxesDropdownsLists {

    public static void SelectCheckbox() {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");


    }

    public static void clickOnRandomCheckBox() throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        Thread.sleep(5000);
        List<WebElement> checkboxes = driver.findElements(By.className("gwt-CheckBox"));

        List<CheckboxInfoHelper> checkboxInfoHelperList = new ArrayList<>();
        int id = 1;
        for (WebElement checkbox : checkboxes) {
            WebElement input = checkbox.findElement(By.tagName("input"));
            String label = checkbox.findElement(By.tagName("label")).getText();

            if (input.isEnabled()) {
                // create object and add to list
                CheckboxInfoHelper checkboxInfoHelper = new CheckboxInfoHelper(id, label, input);
                checkboxInfoHelperList.add(checkboxInfoHelper);
                id++;
            }
        }

        int counterClickedFriday = 1;
        while (counterClickedFriday <= 3) {
            int randomNr = getRandomNumber(1, checkboxInfoHelperList.size() +1);
            // Filter out checkboxes list by id
            CheckboxInfoHelper checkboxInfoHelper = checkboxInfoHelperList.stream().filter(c -> c.id == randomNr).collect(Collectors.toList()).get(0);
            checkboxInfoHelper.checkbox.click();
           // Thread.sleep(3000);
            System.out.println(checkboxInfoHelper.name);
            checkboxInfoHelper.checkbox.click();
           // Thread.sleep(3000);
            if (checkboxInfoHelper.name.equalsIgnoreCase("friday")) {
                counterClickedFriday++;
            }

        }
        driver.close();


    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void main(String[] args) throws InterruptedException {

        //SelectCheckbox();
        clickOnRandomCheckBox();
    }
}
