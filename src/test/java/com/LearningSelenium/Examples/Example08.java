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

public class Example08 {

    @Test
    public void test_lunchbroiwser() throws InterruptedException {

        // Set up the Edge options for maximized window
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");

        // Initialize EdgeDriver
        WebDriver driver = new EdgeDriver(options);

        // Navigate to the login page
        driver.get("https://www.idrive360.com/enterprise/login");

        // Set up WebDriverWait to wait for elements to be available
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait for the email field and send the email
        WebElement Email = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='username']")));
        Email.sendKeys("augtest_040823@idrive.com");

        // Wait for password field and send the password
        WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='password']")));
        password.sendKeys("123456");

        // Wait for sign-in button and click it
        WebElement singin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='frm-btn']")));
        singin.click();

        // Wait for the 'Free Trial' element to be visible
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@id='expiredmsg']")));
            System.out.println(element.getText());
        } catch (Exception e) {
            System.out.println("Element not found or visible within timeout.");
        }

        // Quit the driver to close the browser
        driver.quit();
    }
}
