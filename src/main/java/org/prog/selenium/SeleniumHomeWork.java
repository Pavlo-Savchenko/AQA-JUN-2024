package org.prog.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
        try {
            driver = new ChromeDriver();
            driver.get("https://allo.ua/");
            WebElement searchBox = driver.findElement(By.name("search") );
            searchBox.sendKeys("iphone 15");
            searchBox.sendKeys(Keys.ENTER);
        }finally{
            if(driver!=null){
                driver.quit();
            }
        }
    }
}
