package com.LearningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Example014 {

    EdgeOptions options;
    @BeforeTest
    public void openbrowser(){
        options=new EdgeOptions();
        options.addArguments("--start-maximized");


    }
@Test
    public void test_wait() throws InterruptedException {

        WebDriver driver =new EdgeDriver(options);

        driver.get("https://www.makemytrip.com/");
        Thread.sleep(5000);
        WebElement close_window=driver.findElement(By.xpath("//span[@data-cy='closeModal']"));

        close_window.click();

        Thread.sleep(3000);

        WebElement SearchFrom= driver.findElement(By.xpath("//input[@id='fromCity']"));

            Actions action=new Actions(driver);
            action.moveToElement(SearchFrom).click().sendKeys("BLR").click().build().perform();
    Thread.sleep(3000);

    action.moveToElement(SearchFrom).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).build().perform();


    Thread.sleep(3000);
        driver.quit();

    }

}
