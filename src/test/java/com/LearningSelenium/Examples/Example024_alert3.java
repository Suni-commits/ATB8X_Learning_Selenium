package com.LearningSelenium.Examples;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Example024_alert3 {

    @Test
    public void test_alert3Method() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsprompt= driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsprompt.click();

        Alert alert3=driver.switchTo().alert();
        alert3.sendKeys("HELLO");
        alert3.accept();

        WebElement resultText= driver.findElement(By.id("result"));
        resultText.getText();

        Thread.sleep(3000);

        driver.quit();

    }
}
