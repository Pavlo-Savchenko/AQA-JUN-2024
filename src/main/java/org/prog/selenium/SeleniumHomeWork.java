package org.prog.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumHomeWork {

    /**
     * HOME WORK 5
     * write selenium code that will:
     * - load allo.ua
     * - set search to 'iphone 15' or any iphone
     * - execute search
     * @param args
     */

    public static void main(String[] args) {
        WebDriver driver = null;
        String devise = "iphone 15";
        try {
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
        }finally{
            if(driver!=null){
                driver.quit();
            }
        }
    }
}

