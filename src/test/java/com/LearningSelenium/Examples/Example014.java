
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

public class Example014 {

    @Test
    public void test_method() {
        WebDriver driver = null;
        try {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--start-maximized");

            driver = new EdgeDriver(options);
            driver.get("https://demo.us.espocrm.com/?l=en_US#Lead");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

            WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btn-login']")));
            loginButton.click();

            WebElement createLeadButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='fas fa-plus fa-sm']/following-sibling::span")));
            createLeadButton.click();

            // Wait for the salutation dropdown and click
            WebElement select = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='salutationName']")));
            select.click();

            WebElement optionMr = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@name='salutationName']/option[@value='Mr.']")));
            optionMr.click();



        } catch (Exception e) {
            e.printStackTrace(); // Log exception (if any)
        } finally {
            if (driver != null) {
                driver.quit(); // Ensure browser closes after execution
            }
        }
    }
}
