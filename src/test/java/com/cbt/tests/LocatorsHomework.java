package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class LocatorsHomework {
    public static void AmazonTest()
    {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://amazon.com");
        WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
        element.click();
        String itemToSearch = "iPhone Cases";
        element.sendKeys(itemToSearch);
        driver.findElement(By.className("nav-input")).click();
        if(driver.getTitle().toLowerCase().contains(itemToSearch.toLowerCase()))
        {
            System.out.println("PASS");
        }
        else
        {
            System.out.println("FAIL");
            System.out.println("The item we searched : " + itemToSearch);
            System.out.println("Title = " + driver.getTitle());
        }
        driver.close();
    }
    public static void WikipediaTest()
    {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://wikipedia.com");
        WebElement element = driver.findElement(By.id("searchInput"));
        element.click();
        element.sendKeys("selenium webdriver" + Keys.ENTER);
        driver.findElement(By.linkText("Selenium (software)")).click();
        if(driver.getCurrentUrl().endsWith("Selenium_(software)"))
        {
            System.out.println("PASS");
        }
        else
        {
            System.out.println("FAIL");
            System.out.println("Current URL = " + driver.getCurrentUrl());
            System.out.println("Expected end  = Selenium_(software)");
        }
        driver.close();

    }
    public static void GoogleTest()
    {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://google.com");
        List<String> searchStrs = Arrays.asList("Java", "cucumber bdd", "Selenium web browser automation" );
        WebElement element = driver.findElement(By.name("q"));

        for (int i = 0; i < searchStrs.size(); i++)
        {
            element = driver.findElement(By.name("q"));
            element.click();
            element.clear();
            element.sendKeys(searchStrs.get(i) + Keys.ENTER);
            String nameX = driver.findElement(By.xpath("//cite[1]")).getText();
            nameX = "https://" + nameX + "/";
            driver.findElement(By.xpath("(//div[@class='rc']/div/a )[1]")).click();
            StringUtility.verifyEquals(nameX, driver.getCurrentUrl());
            driver.navigate().back();

        }
        driver.close();

    }
    public static void EbayTest()
    {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://ebay.com");
        WebElement element = driver.findElement(By.id("gh-ac"));
        element.click();
        element.sendKeys("wooden spoon" + Keys.ENTER);
        //String nrOfResults = driver.findElement(By.className("BOLD")).getText(); /html/body/div[4]/div[5]/div[1]/div/div[2]/div/div[1]/h1/span[1]
        String nrOfResults = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[2]/div/div[1]/h1/span[1]")).getText();
        nrOfResults = nrOfResults.replace(",", "");
        driver.findElement(By.xpath("//*[@id=\"x-refine__group__0\"]/ul/li/a/span")).click();
        String allResults = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div/div[2]/div/div[1]/h1/span[1]")).getText();
        allResults = allResults.replace("," , "");
        int res1 = Integer.parseInt(nrOfResults);
        int res2 = Integer.parseInt(allResults);
        if(res2>res1)
        {
            System.out.println("PASS");
        }
        else
        {
            System.out.println("FAIL");
            System.out.println("res2 = " + res2);
            System.out.println("res1 = " + res1);
        }

        driver.navigate().back();
        String currentSearchBoxTxt = driver.findElement(By.id("gh-ac")).getAttribute("value");
        StringUtility.verifyEquals(currentSearchBoxTxt, "wooden spoon");
        driver.navigate().back();
        String homeSearchBoxTxt = driver.findElement(By.id("gh-ac")).getAttribute("value");
        StringUtility.verifyEquals(homeSearchBoxTxt, "");
        driver.close();

    }

    public static void VyTrackTest() throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://app.vytrack.com/user/login");
        String username = "user1";
        String password = "UserUser123";
        String firstName = "John";
        String lastName = "Doe";
        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password);
        driver.findElement(By.id("_submit")).click();

        WebElement name = driver.findElement(By.className("dropdown-toggle"));
        name.click();
        driver.findElement(By.cssSelector(".mobile-hide a")).click();
        Thread.sleep(5000);
        if(driver.getTitle().startsWith(name.getText())){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
            System.out.println("Expected = " + name.getText());
            System.out.println("Actual = " + driver.getTitle());
        }

    }

    private static void VyTrackShortcutTest() throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://app.vytrack.com/user/login");
        String username1 = "salesmanager102";
        String password1 = "UserUser123";
        String name = "Easton";
        String lastname = "Mante";
        driver.findElement(By.id("prependedInput")).sendKeys(username1);
        driver.findElement(By.id("prependedInput2")).sendKeys(password1);
        driver.findElement(By.id("_submit")).click();

        String pageTitle = "Dashboard";
        if(driver.getTitle().equals(pageTitle)){
            System.out.println("PASS - Currently on Dashboard page");
        }
        else{
            System.out.println("FAIL");
        }
        WebElement pagetitle = driver.findElement(By.className("fa-share-square"));
        Thread.sleep(5000);
        pagetitle.click();
        driver.findElement(By.xpath("//*[@id=\"oroplatform-header\"]/div[1]/div/div[2]/div/ul/li[2]/form/div/div/a")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/table/tbody/tr[4]/td[1]/a")).click();
        Thread.sleep(5000);
        String currentTitle = "Accounts By Opportunities";
        if(driver.getTitle().contains(currentTitle)){
            System.out.println("PASS - Still on Accounts By Opportunities page");
        }
        else{
            System.out.println("FAIL");
        }
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"oroplatform-header\"]/div[1]/div/div[2]/div/a")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"oroplatform-header\"]/div[1]/div/div[2]/div/ul/li[2]/form/div/div/a")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/table/tbody/tr[17]/td[1]/a")).click();
        Thread.sleep(5000);
        String errorMessage = "You do not have permission to perform this action.";
        if(driver.findElement(By.xpath("//*[@id=\"flash-messages\"]/div/div/div/div")).getText().equals(errorMessage)){
            System.out.println("PASS - Error message is correct");
        }else{
            System.out.println("Wrong Error Message");
        }
        String expectedCurrentTitle = "Shortcut Actions List";
        if(driver.getTitle().equals(expectedCurrentTitle)){
            System.out.println("PASS - Still on shortcuts actions list page");
        }else{
            System.out.println("FAIL");
        }

        Thread.sleep(5000);
        driver.close();

    }


    public static void main(String[] args) throws InterruptedException {
        //AmazonTest();
        //WikipediaTest();
        //GoogleTest();
        //EbayTest();
        //VyTrackTest();
        VyTrackShortcutTest();

    }

}