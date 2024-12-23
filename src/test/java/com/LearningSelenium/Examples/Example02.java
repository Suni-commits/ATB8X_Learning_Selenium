package com.LearningSelenium.Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Example02 {

    @Test
    public void test_appointment() throws Exception {

        ChromeOptions options=new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver=new ChromeDriver(options);
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        //Appointment button
       WebElement makeAppointmentButton= driver.findElement(By.id("btn-make-appointment"));
       makeAppointmentButton.click();

       // find username and password fields
        WebElement username=driver.findElement(By.id("txt-username"));
        WebElement password= driver.findElement(By.id("txt-password"));

        username.sendKeys("John Doe");
        password.sendKeys("ThisIsNotAPassword");

        WebElement submitbutton=driver.findElement(By.id("btn-login"));
        submitbutton.click();

        String expectedUrl="https://katalon-demo-cura.herokuapp.com/#appointment";
        String actualurl=driver.getCurrentUrl();

        if(actualurl.equals(expectedUrl)){
            System.out.println("Actual and Expected URLs are same "+expectedUrl);
        }
        else{
            throw new Exception("Actual and expected urls are not same");
        }
        driver.quit();
    }
}
