package com.LearningSelenium.Dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class DataProviderDemo {

    WebDriver driver;

    @BeforeClass
    void setUp(){
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");

    }

    @Test
    public void Test_Login() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("testsuni@gmail.com");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("test@123");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Thread.sleep(4000);
        String status = driver.findElement(By.xpath("//span[normalize-space()='My Account']")).getText();
        Thread.sleep(4000);
      driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
      assertThat(status).isEqualTo("My Account");

    }


    @AfterClass
    void tearDown(){
        driver.quit();
    }



}
