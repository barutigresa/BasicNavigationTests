package com.cbt.tests;
import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.Random;

public class YearsMonthsDays {
    public static void dropdownDateTest() {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        Select days = new Select(driver.findElement(By.id("day")));

        int nrOfDays = days.getOptions().size();

        Random random = new Random();
        Select years = new Select(driver.findElement(By.id("year")));

        years.selectByIndex(random.nextInt(years.getOptions().size()-1));
        int randomYear = Integer.parseInt(years.getFirstSelectedOption().getText());

        System.out.println("Randomly selected year: "+years.getFirstSelectedOption().getText());

        boolean leapYear = false;
        if (randomYear % 4 == 0 && ( randomYear % 100 != 0 || randomYear % 400 == 0 ) ) {
            leapYear = true;
        }

        Select months = new Select(driver.findElement(By.id("month")));
        for(int i = 0; i < months.getOptions().size(); i++) {
            months.selectByIndex(i);
            days = new Select(driver.findElement(By.id("day")));
            int SelectedMonthDays = days.getOptions().size();
            if(leapYear && months.getFirstSelectedOption().getText().equals("February")) {
                System.out.println(months.getFirstSelectedOption().getText()+" has only "+SelectedMonthDays+" days since it is a Leap Year");
            }
            if(nrOfDays == SelectedMonthDays) {
                System.out.println("PASS");
                System.out.println(months.getFirstSelectedOption().getText()+" same number of days("+SelectedMonthDays+") as selected month("+nrOfDays+")");
            } else {
                System.out.println("FAIL");
                System.out.println(months.getFirstSelectedOption().getText()+" not the same number of days("+SelectedMonthDays+") as selected month("+nrOfDays+")");
            }
        }
    }

    public static void main(String[] args) {
        dropdownDateTest();
    }
}