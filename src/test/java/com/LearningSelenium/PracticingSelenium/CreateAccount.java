package com.LearningSelenium.PracticingSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class CreateAccount {

    @Test
    public void test_registeraccount() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");

        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Testing1223");
        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Tester");
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("test13@gmail.com");
        driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("234123445");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Test1234");
        driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Test1234");
        driver.findElement(By.xpath("//input[@name='agree']")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        Thread.sleep(3000);
        driver.quit();


    }

}
