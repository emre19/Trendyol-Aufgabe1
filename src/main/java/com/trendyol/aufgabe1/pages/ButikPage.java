package com.trendyol.aufgabe1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class ButikPage extends BasePage {

    private By allButikListBy = By.cssSelector(".main-nav > li");
    private By kisiselBy = By.xpath("//*[@id=\"browsing-gw-homepage\"]//div[@data-index=2]//span[text()='Kişisel Bakım']");
    private By emreBy = By.xpath("//div[@id=\"browsing-gw-navigation\"]//ul[@class=\"main-nav\"]/child::li[5]");

    public ButikPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ButikPageResult randomButik() throws InterruptedException {
        List<WebElement> butiks = webDriver.findElements(allButikListBy);

        click(emreBy,10);
        click(kisiselBy,10);
        return new ButikPageResult(webDriver);
    }

    public void allButikClickAndImageControl(){
        List<WebElement> butiks = webDriver.findElements(allButikListBy);

        for (int i=0; i < butiks.size(); i++){

            try{
                butiks.get(i).click();
                imageControl();
            }catch (StaleElementReferenceException e){
                butiks = webDriver.findElements(allButikListBy);
                butiks.get(i).click();
                imageControl();
            }
        }
    }

    public void imageControl(){
        List<WebElement> images = webDriver.findElements(By.tagName("img"));
        System.out.println(images.size());

        for (WebElement image : images) {
            String imageSrc = image.getAttribute("src");

            try {
                URL url = new URL(imageSrc);
                URLConnection urlConnection = url.openConnection();
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) urlConnection;
                httpsURLConnection.setConnectTimeout(5000);
                httpsURLConnection.connect();

                if (httpsURLConnection.getResponseCode() == 200) {
                    System.out.println(imageSrc + " >> " + httpsURLConnection.getResponseCode() + " >> " + httpsURLConnection.getResponseMessage());
                } else
                    System.err.println(imageSrc + " >> " + httpsURLConnection.getResponseCode() + " >> " + httpsURLConnection.getResponseMessage());
                httpsURLConnection.disconnect();
            } catch (Exception e) {
                System.err.println(imageSrc);
            }
        }
    }
}
