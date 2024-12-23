package com.LearningSelenium.Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Example03 {

    @Test
    public void test_CuraLogin() throws Exception {

        EdgeOptions options=new EdgeOptions();

        options.addArguments("--start-maximized");

        WebDriver driver=new EdgeDriver(options);

        driver.get("https://katalon-demo-cura.herokuapp.com/");
        // finding make appointment button
        WebElement makeappointmentbutton=driver.findElement(By.id("btn-make-appointment"));
        makeappointmentbutton.click();

        //usernamme and password elements capturing

        WebElement username=driver.findElement(By.id("txt-username"));
        WebElement password=driver.findElement(By.id("txt-password"));
        //sending username and password
        username.sendKeys("John Doe");
        password.sendKeys("ThisIsNotAPassword");

        // Login

        WebElement submitbutton= driver.findElement(By.id("btn-login"));
        submitbutton.click();

        // Verifying appointment url after logged in

        String expectedurl="https://katalon-demo-cura.herokuapp.com/#appointment";
        String actualurl=driver.getCurrentUrl();

        if(actualurl.equals(expectedurl))
        {
            System.out.println("Both Actual and  Expected Urls are same : "+actualurl);
        }
        else{
            throw new Exception("Both actual and expected urls are not same");
        }
        Thread.sleep(2000);

        driver.quit();
    }
}
