package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class Cart {

    public static void cartTest() throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon");
        driver.findElement(By.className("nav-input")).click();

        List<WebElement> results = driver.findElements(By.xpath("//h2//a//span"));
        Random random = new Random();

        int randNr = random.nextInt(results.size() - 1);

        String whole = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[" + (randNr + 1) + "]")).getText();
        String fraction = driver.findElement(By.xpath("(//span[@class='a-price-fraction'])[" + (randNr + 1) + "]")).getText();
        String price = "$" + whole + "." + fraction;
        String header = results.get(randNr).getText();

        results.get(randNr).click();
        Thread.sleep(2000);

        WebElement quantity = driver.findElement(By.className("a-dropdown-prompt"));

        if (quantity.getText().equals("1")) {
            System.out.println("PASS - quantity is 1");
        } else {
            System.out.println("FAIL - quantity is: " + quantity.getText());
        }

        Thread.sleep(2000);

        String nextHeader = driver.findElement(By.id("productTitle")).getText();
        String nextPrice = driver.findElement(By.id("price_inside_buybox")).getText();

        if (nextHeader.equals(header) && nextPrice.equals(price)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected: " + nextHeader);
            System.out.println("Expected: " + nextPrice);
            System.out.println("Actual: " + header);
            System.out.println("Actual: " + price);
        }
        WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));

        if (addToCart.isDisplayed()) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL - element not visible");
        }
    }

    public static void main  (String[] args) throws InterruptedException {
        cartTest();
    }
}
