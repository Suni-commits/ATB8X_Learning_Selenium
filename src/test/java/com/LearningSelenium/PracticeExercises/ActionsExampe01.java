package com.LearningSelenium.PracticeExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsExampe01 {

    @Test
    public void test() throws InterruptedException {

        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://awesomeqa.com/practice.html");

        WebElement element=driver.findElement(By.xpath("//input[@name='firstname']"));

        Actions action=new Actions(driver);
        action.keyDown(Keys.SHIFT).sendKeys(element,"The testing academy").keyUp(Keys.SHIFT).build().perform();
        Thread.sleep(2000);

        driver.quit();

    }
}
