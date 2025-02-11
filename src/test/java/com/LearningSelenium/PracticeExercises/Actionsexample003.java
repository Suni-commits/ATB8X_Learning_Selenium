package com.LearningSelenium.PracticeExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Actionsexample003 {

    @Test
    public void test_spicejet_Keys() throws InterruptedException {
        WebDriver driver=new EdgeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

        driver.get("https://www.spicejet.com/");

        WebElement element=driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']/input"));

        Actions action=new Actions(driver);

        action.moveToElement(element).click().sendKeys("BLR").build().perform();

        Thread.sleep(3000);

        action.moveToElement(element).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();

        driver.quit();

    }
}
