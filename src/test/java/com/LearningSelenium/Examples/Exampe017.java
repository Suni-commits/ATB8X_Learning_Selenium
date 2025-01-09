package com.LearningSelenium.Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Exampe017 {

    EdgeDriver driver;

    @BeforeTest
    public void OpenBrowser(){
        EdgeOptions option=new EdgeOptions();
        option.addArguments("--guest");
        driver=new EdgeDriver(option);
    }

    @Test
    public void test_keys(){
        driver.get("https://awesomeqa.com/practice.html");
        WebElement firstName= driver.findElement(By.name("firstname"));

        Actions action=new Actions(driver);
        // from keyboard when if enter small letters then it should take caps

        action.keyDown(Keys.SHIFT).sendKeys(firstName,"i am suneetha").keyUp(Keys.SHIFT).build().perform();


    }

    @AfterTest
    public void closeBrowser(){
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
