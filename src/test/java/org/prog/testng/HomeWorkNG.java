package org.prog.testng;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.prog.page.AlloPage;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HomeWorkNG {
    private WebDriver driver;
    private AlloPage alloPage;
    @BeforeSuite
    public void precondition(){
        driver = new ChromeDriver();
        alloPage=new AlloPage(driver);
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
        alloPage.loadPage();
        alloPage.setSearchValue(devise);
        alloPage.executeSearch();
        int g =0;
        for(WebElement img : alloPage.getSearchProducts() ) {
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
        alloPage.getSearchFirstPrices();
        WebElement firstElement=alloPage.getSearchFirstPrices().get(0);
        String firstPrice= firstElement.getText();
        alloPage.getSearchPhoneElement();
        alloPage.getSearchPrice2();
        WebElement thirdElement=alloPage.getSearchPrice2().get(3);
        String secondPrice=thirdElement.getText();

        Assert.assertEquals(firstPrice, secondPrice,"ціна має бути однакова");

    }
}