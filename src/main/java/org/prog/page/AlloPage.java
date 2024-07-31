package org.prog.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.prog.util.CucumberStorage;

import java.time.Duration;
import java.util.List;

public class AlloPage {
    private final WebDriver driver;

    public AlloPage(WebDriver driver) {
        this.driver = driver;
    }


    public void loadPage() {
        driver.get("https://allo.ua/");
    }

    public void setSearchValue(String value) {
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys(value);
    }

    public void executeSearch() {
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys(Keys.ENTER);
    }

    public List<WebElement> getSearchPhoneElement() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30L));
        List<WebElement> searchPhoneElement =
                driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//img[contains(@src,'https://i.allo.ua/media/catalog/product/cache/3/small_image/212x184/9df78eab33525d08d6e5fb8d27136e95/i/p/iphone_15')]"), 4));
        searchPhoneElement.get(0).click();
        return searchPhoneElement;
    }
    public String nameElementFoTable() {
        WebElement findName = driver.findElement(By.xpath("//h1[contains(@class,'p-view__header-title')]"));
       String nameEl = findName.getText();
        CucumberStorage.HOLDER.put("nameSomePhone",nameEl);
        return nameEl;
    }

    public String priseElementFoTable(){
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30L));
        List<WebElement> searchPrice2=
                driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//span[contains(@class,'sum')]"),2));
        System.out.println(searchPrice2.get(2).getText());
        WebElement thirdElement=searchPrice2.get(2);
        String secondPrice=thirdElement.getText();
        CucumberStorage.HOLDER.put("PricePhone",secondPrice);
        return secondPrice ;
    }
}