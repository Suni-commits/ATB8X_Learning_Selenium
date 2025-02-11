package com.LearningSelenium.PracticeExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class Actions_KEYSExamples01 {

    @Test
    public void test() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();


        driver.get("https://www.makemytrip.com/");

        Thread.sleep(4000);

        driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();

        WebElement fromcity=driver.findElement(By.xpath("//span[normalize-space()='From']"));
        Actions action=new Actions(driver);

        action.moveToElement(fromcity).click().sendKeys("BLR").build().perform();

        Thread.sleep(4000);

        action.moveToElement(fromcity).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();

        driver.quit();


    }
}
