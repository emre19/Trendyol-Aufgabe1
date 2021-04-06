package com.trendyol.aufgabe1.testcases;

import com.trendyol.aufgabe1.pages.*;
import com.trendyol.aufgabe1.testcases.BaseTest;
import com.trendyol.aufgabe1.users.User;
import com.trendyol.aufgabe1.users.UserPool;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ButikTest extends BaseTest {

    @Test
    public void shouldClickButik() throws InterruptedException {

        HomePage homePage = new HomePage(webDriver);
        LoginPage loginPage = homePage.getLoginPage();

        User user = UserPool.getUser1();
        homePage = loginPage.login(user);

        String accountButtonText = homePage.getAccountText();
        assertEquals(accountButtonText, "Hesabım");

        homePage.loginPopupClose();

        ButikPage butikPage = new ButikPage(webDriver);

        //butikPage.allButikClickAndImageControl();

        ButikPageResult butikPageResult = butikPage.randomButik();
        String resultText = butikPageResult.getResultText();
        assertEquals(resultText, "kişisel bakım");

        ButikPageProductDetail butikPageProductDetail = butikPageResult.goProduct();
        boolean isAddBasketDisplayed = butikPageProductDetail.isProductDisplayed();
        assertEquals(isAddBasketDisplayed, true);

        butikPageProductDetail.addToBasket();
        assertEquals(butikPageProductDetail.isAddedBasket("Sepete Eklendi"),true);
    }
}
