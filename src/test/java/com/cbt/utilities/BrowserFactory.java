package com.cbt.utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    public static WebDriver getDriver(String browser){

        if(browser.equalsIgnoreCase("chrome")){

            System.setProperty("webdriver.chrome.driver",
                    "C:\\Users\\Default\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
            return new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver",
                    "C:\\Users\\Default\\Documents\\selenium dependencies\\drivers\\geckodriver.exe");
            return new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver",
                    "C:\\Users\\Default\\Documents\\selenium dependencies\\drivers\\msedgedriver.exe");
            return new EdgeDriver();
        }
        else{
            return null;
        }
    }
}