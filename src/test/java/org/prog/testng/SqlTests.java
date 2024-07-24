package org.prog.testng;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.sql.*;
import java.time.Duration;
import java.util.List;

public class SqlTests {
    //TODO: w3schools : create table
    //TODO: add table to DB with goods name and price
    //TODO: w3schools : insert into table
    //TODO: make your test store product's rice and name in DB
    //TODO: w3schools : select from table WHERE + update table
    //TODO: * make test update data in DB if the goods name is already present

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private WebDriver driver;
    private final static String INSERT_PATTERN="INSERT INTO IPhoneTable (NamePhone,PrisePhone)" +
            "VALUES ('%s', '%s')";
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
    public void insertIntoDBTest() throws SQLException, ClassNotFoundException {
        connectionToDB();
        try {
            String str= nameElementFoTable(driver);
            String str2= priseElementFoTable(driver);
            statement.execute(String.format(INSERT_PATTERN,str,str2));

        } finally {
            closeConnection();
        }
    }
    private void connectionToDB() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "password");
        statement = connection.createStatement();
    }
    private void closeConnection() throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
    public String nameElementFoTable(WebDriver  dr){
        String devise = "iphone 15";
        driver.get("https://allo.ua/");
        WebElement searchBox = driver.findElement(By.name("search") );
        searchBox.sendKeys(devise);
        searchBox.sendKeys(Keys.ENTER);

        WebDriverWait driverWait= new WebDriverWait(driver, Duration.ofSeconds(30L));

        List<WebElement> searchPhoneElement=
                driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//img[contains(@src,'https://i.allo.ua/media/catalog/product/cache/3/small_image/212x184/9df78eab33525d08d6e5fb8d27136e95/i/p/iphone_15')]"),4 ));
        searchPhoneElement.get(0).click();

        WebElement findName = driver.findElement(By.xpath("//h1[contains(@class,'p-view__header-title')]"));
        WebElement nameElement=findName;
        String nameEl=nameElement.getText();
        System.out.println(nameEl );
        return nameEl ;
    }
    public String priseElementFoTable(WebDriver  dr){
        String devise = "iphone 15";
        driver.get("https://allo.ua/");
        WebElement searchBox = driver.findElement(By.name("search") );
        searchBox.sendKeys(devise);
        searchBox.sendKeys(Keys.ENTER);

        WebDriverWait driverWait= new WebDriverWait(driver, Duration.ofSeconds(30L));

        List<WebElement> searchPhoneElement=
                driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//img[contains(@src,'https://i.allo.ua/media/catalog/product/cache/3/small_image/212x184/9df78eab33525d08d6e5fb8d27136e95/i/p/iphone_15')]"),4 ));
        searchPhoneElement.get(0).click();

        List<WebElement> searchPrice2=
                driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//span[contains(@class,'sum')]"),2));
        System.out.println(searchPrice2.get(2).getText());
        WebElement thirdElement=searchPrice2.get(2);
        String secondPrice=thirdElement.getText();

        return secondPrice ;
    }
}
