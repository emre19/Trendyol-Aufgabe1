package com.trendyol.aufgabe1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private By componentListBy = By.className("component-list");
    private By popupBy = By.id("Group-38");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void waitForLoad() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(componentListBy));
    }

    public void loginPopupClose(){
        click(popupBy,10);
    }

}