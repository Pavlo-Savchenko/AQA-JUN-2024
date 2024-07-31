package org.prog.cucumber.steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.page.AlloPage;
import org.prog.util.CucumberStorage;

import java.util.List;
import java.util.Set;


public class WebSteps {



    public static String somePhone="iphone 15";

    public static AlloPage alloPage;

    @Given("I load allo page")
    public void loadAlloPage(){
        alloPage.loadPage();
    }
    @Given("I search searchbox and enter value")
    public void enterSearchValue(){
        alloPage.setSearchValue(somePhone);
    }
    @Given("I press ENTER")
    public void pressEnter(){
        alloPage.executeSearch();
    }
    @Given("I click phone")
    public void clickPhone(){
        alloPage.getSearchPhoneElement();
    }
    @Given("I search phone name")
    public void searchName(){
        alloPage.nameElementFoTable();
    }
    @Given("I search phone price")
    public void searchPrice(){
        alloPage.priseElementFoTable();
    }

}