package com.LearningSelenium.Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class Login_Exampe04 {

    @Test
    public void test_Negative_VWOapp() throws InterruptedException {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        WebDriver driver=new ChromeDriver(options);

        driver.get("https://app.vwo.com/#/login");

        // finding elements for email address and password

        WebElement emailaddress=driver.findElement(By.id("login-username"));
        WebElement password=driver.findElement(By.id("login-password"));
        //Assigningg values to the input elements

        emailaddress.sendKeys("adbce@xyz.com");
        password.sendKeys("password");



        // Login button

        WebElement submit=driver.findElement(By.id("js-login-btn"));
        submit.click();



        // verify the error message


        WebElement error_message =driver.findElement(By.className("notification-box-description"));
        error_message.getText().equals("Your email, password, IP address or location did not match");

    //   assertThat(error_message.getText()).isEqualTo("Your email, password, IP address or location did not match");
        Thread.sleep(3000);


        driver.quit();


    }
}
