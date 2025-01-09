package com.LearningSelenium.Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Example016 {

    EdgeDriver driver;
@BeforeTest
    public void openbroser(){
        EdgeOptions option=new EdgeOptions();
        option.addArguments("--guest");
        driver=new EdgeDriver(option);
    }

    @Test
    public void test_ActionKeys(){
        driver.get("https://www.spicejet.com");
        WebElement Fromcity= driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/div/div/input"));

        Actions action=new Actions(driver);

        action.moveToElement(Fromcity).click().sendKeys("HYD").build().perform();

    }

    @AfterTest
    public void closeBrowser(){
    try{
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    }

}
