package org.prog.testng;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
                driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//span[contains(@class,'sum')]"),5));
        System.out.println("перший телефон коштує: "+searchPrice.get(0).getText());
    }
}


