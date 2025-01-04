package com.LearningSelenium.Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Exampe011 {

    @Test
    public void test_InvalidLoginCredentials() throws Exception {

        EdgeOptions options=new EdgeOptions();

        options.addArguments("--incognito");

        WebDriver driver=new EdgeDriver(options);

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));

        driver.get("https://www.opencart.com/");

        WebElement login= driver.findElement(By.xpath("//a[@class='btn btn-link navbar-btn']"));

        login.click();

        WebElement Email=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='input-email']")));

        Email.sendKeys("test@gmail.com");

        WebElement password=driver.findElement(By.xpath("//input[@id='input-password']"));

        password.sendKeys("2345aad");

        WebElement Login=driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block visible-xs-block']"));

        Login.click();

        Thread.sleep(2000);

        WebElement elementmessage=driver.findElement(By.xpath("//div[@class='alert alert-danger']"));

        elementmessage.getText();

        if(elementmessage.isDisplayed()){
            System.out.println("Throwing an invalid error message for invalid credenias");
        }
        else{
         throw new Exception("Text not found");
        }

        driver.quit();


    }
}
