package com.trendyol.aufgabe1.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public static WebDriver startApplication(WebDriver driver, String browserName, String appURL){
        
        if(browserName.equals("Chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }
        else if(browserName.equals("Firefox")){
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--disable-notifications");

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(options);
        }
        else{
            System.out.println("We do not support this browser");
        }

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(appURL);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.className("fancybox-close"))
                .click();

        return driver;
    }

    public static void quitBrowser(WebDriver driver){
        driver.quit();
    }
}
