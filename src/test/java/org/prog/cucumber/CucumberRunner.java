package org.prog.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.prog.cucumber.steps.WebSteps;
import org.prog.driver.WedDriverFactory;
import org.prog.page.AlloPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

@CucumberOptions (
        features = "src/test/resources/features",
        glue = "org.prog.cucumber.steps",
        plugin = {"pretty",
        "json:target/cucumber-reports/Cucumber.json",
        "html:target/cucumber-report.html"
        })
public class CucumberRunner extends AbstractTestNGCucumberTests  {
private WebDriver driver;
@BeforeSuite
    public void init(){
    driver= WedDriverFactory.getDriver();
    WebSteps.alloPage=new AlloPage(driver );
}
@AfterSuite
    public void tearDown(){
    driver.quit();
}
}
