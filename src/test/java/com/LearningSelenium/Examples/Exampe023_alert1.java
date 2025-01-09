package com.LearningSelenium.Examples;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Exampe023_alert1 {

    @Test
    public void test_alert2method() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsconfirm= driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));

        jsconfirm.click();
        Alert alert2=driver.switchTo().alert();
        alert2.accept();

        WebElement resulttext= driver.findElement(By.id("result"));
        resulttext.getText();

        Thread.sleep(3000);

        driver.quit();

    }


}
