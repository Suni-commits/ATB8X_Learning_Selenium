package com.LearningSelenium.Examples;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Example022_Alerts {

    @Test
    public void test_alertshandle() throws InterruptedException {

        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsAlert= driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));

        jsAlert.click();

        Alert alert1=driver.switchTo().alert();
        alert1.accept();

        WebElement resultselement= driver.findElement(By.id("result"));
        resultselement.getText();

        Thread.sleep(3000);

        driver.quit();


    }
}
