package com.trendyol.aufgabe1.pages;

import com.trendyol.aufgabe1.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BasePage extends WebDriverHelper {

    private By accountButtonBy = By.className("account-user");

    public BasePage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage getLoginPage() {
        click(accountButtonBy, 10);
        return new LoginPage(webDriver);
    }

    public String getAccountText() {
        return getText(accountButtonBy);
    }
}
