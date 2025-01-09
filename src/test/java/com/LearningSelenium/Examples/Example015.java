package com.LearningSelenium.Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Example015 {

    @Test
    public void test_actionwithKey() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(8));

        WebElement closewindow=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));

        closewindow.click();

        WebElement Fromcity=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='fromCity']")));

        Actions action=new Actions(driver);
        action.moveToElement(Fromcity).click().sendKeys("DEL").click();

        action.moveToElement(Fromcity).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).build().perform();

        Thread.sleep(3000);

        driver.quit();
    }
}
