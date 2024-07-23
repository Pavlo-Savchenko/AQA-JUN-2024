package org.prog.testng;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HomeWorkNG {

    //TODO: move your allo.ua test to TestNG Test
    //TODO: make browser start/stop as Before/After suite
    //TODO: print 1st good's price
    private WebDriver driver;
    @BeforeSuite
    public void precondition(){
        driver = new ChromeDriver();
    }
    @AfterSuite
    public void postCondition(){
        if(driver!=null){
            driver.quit();
        }
    }
    @Test
    public void myTest(){
        String devise = "iphone 15";
        driver.get("https://allo.ua/");
        WebElement searchBox = driver.findElement(By.name("search") );
        searchBox.sendKeys(devise);
        searchBox.sendKeys(Keys.ENTER);

        WebDriverWait driverWait= new WebDriverWait(driver, Duration.ofSeconds(30L));
        List<WebElement > searchIphones =
                driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//a[contains(@title,'Apple iPhone 15')]"),5));
        int g =0;
        for(WebElement img : searchIphones ) {
            img.getText();
            if((img.getText().toUpperCase().contains(devise.toUpperCase()))){
                g++;
            }
        }
        if(g>5){
            System.out.println(devise+ " Знайшло на алло");
        }else{
            throw new RuntimeException(devise + " не знайшло");
        }
        List<WebElement> searchPrice=
                driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[contains(@class,'v-pb__cur discount')]"),5));
        System.out.println("перший телефон коштує: "+searchPrice.get(0).getText());
        WebElement firstElement=searchPrice.get(0);
        String firstPrice= firstElement.getText();

        List<WebElement> searchPhoneElement=
                driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//img[contains(@src,'https://i.allo.ua/media/catalog/product/cache/3/small_image/212x184/9df78eab33525d08d6e5fb8d27136e95/i/p/iphone_15')]"),4 ));
        searchPhoneElement.get(0).click();

        List<WebElement> searchPrice2=
                driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//span[contains(@class,'sum')]"),2));
        System.out.println(searchPrice2.get(3).getText());
        WebElement thirdElement=searchPrice2.get(3);
        String secondPrice=thirdElement.getText();


        WebElement findName = driver.findElement(By.xpath("//h1[contains(@class,'p-view__header-title')]"));
        WebElement nameElement=findName;
        String nameEl=nameElement.getText();
        System.out.println(nameEl );

        Assert.assertEquals(firstPrice, secondPrice,"ціна має бути однакова");

    }
}
