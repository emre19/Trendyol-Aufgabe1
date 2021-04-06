package com.trendyol.aufgabe1.testcases;

import com.trendyol.aufgabe1.utility.BrowserFactory;
import com.trendyol.aufgabe1.utility.ConfigDataProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver webDriver;

/*    @BeforeMethod
    public void startUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("https://www.trendyol.com");

        webDriver.findElement(By.className("fancybox-close"))
                .click();
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }*/

    public ConfigDataProvider config;

    @BeforeSuite
    public void setupSuite(){
        config = new ConfigDataProvider();
    }

    @BeforeClass
    public void setup(){
        webDriver = BrowserFactory.startApplication(webDriver, config.getBrowser(), config.getStagingURL());
    }

    @AfterClass
    public void tearDown(){
        BrowserFactory.quitBrowser(webDriver);
    }
}
