package com.trendyol.aufgabe1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ButikPageProductDetail extends BasePage {

    private By basketButtonBy = By.cssSelector("div.add-to-bs-tx");
    private By addedBasketProductBy = By.cssSelector("div.add-to-bs-tx-sc");

    public ButikPageProductDetail(WebDriver webDriver) {
        super(webDriver);
    }

    public void addToBasket() {
        click(basketButtonBy,10);
    }

    public boolean isProductDisplayed() {
        return webDriver.findElement(basketButtonBy).isDisplayed();
    }

    public boolean isAddedBasket(String keyword){
        String basket = getText(addedBasketProductBy);
        if (basket.equals(keyword)){
            return true;
        }
        else return false;
    }
}
