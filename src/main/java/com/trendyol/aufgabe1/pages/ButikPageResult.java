package com.trendyol.aufgabe1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ButikPageResult extends BasePage {

    private By resultTextBy = By.cssSelector(".dscrptn > h1");
    private By allProductListBy = By.className("prdct-cntnr-wrppr");
    private By productBy = By.cssSelector(".prdct-cntnr-wrppr>div");

    public ButikPageResult(WebDriver webDriver) {
        super(webDriver);
    }

    public String getResultText() {
        return webDriver.findElement(resultTextBy).getText();
    }

    public ButikPageProductDetail goProduct() {
        click(productBy,10);
        changeTab();
        return new ButikPageProductDetail(webDriver);
    }

}
