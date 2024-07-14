package org.prog.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class AlloPage {
    private final WebDriver driver;

    public AlloPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage(){
        driver.get("https://allo.ua/");
    }
    public void setSearchValue(String value){
        WebElement searchBox = driver.findElement(By.name("search") );
        searchBox.sendKeys(value);
    }

    public void executeSearch(){
        WebElement searchBox = driver.findElement(By.name("search") );
        searchBox.sendKeys(Keys.ENTER);
    }
    public List<WebElement> getSearchProducts(){
        WebDriverWait driverWait= new WebDriverWait(driver, Duration.ofSeconds(30L));
        List<WebElement > searchIphones =
                driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//a[contains(@title,'Apple iPhone 15')]"),5));
        return  searchIphones;
    }
    public List<WebElement> getSearchFirstPrices(){
        WebDriverWait driverWait= new WebDriverWait(driver, Duration.ofSeconds(30L));
        List<WebElement> searchPrice=
                driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[contains(@class,'v-pb__cur discount')]"),5));
        return searchPrice;
    }
    public List<WebElement> getSearchPhoneElement(){
        WebDriverWait driverWait= new WebDriverWait(driver, Duration.ofSeconds(30L));
        List<WebElement> searchPhoneElement=
                driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//img[contains(@src,'https://i.allo.ua/media/catalog/product/cache/3/small_image/212x184/9df78eab33525d08d6e5fb8d27136e95/i/p/iphone_15')]"),4 ));
        searchPhoneElement.get(0).click();
        return searchPhoneElement;
    }
    public List<WebElement> getSearchPrice2(){
        WebDriverWait driverWait= new WebDriverWait(driver, Duration.ofSeconds(30L));
        List<WebElement> searchPrice2=
                driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//span[contains(@class,'sum')]"),2));
        return searchPrice2 ;
    }
}

