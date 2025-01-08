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

public class Example013 {

    @Test
    public void test_method() throws InterruptedException {

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(options);

        driver.get("https://demo.us.espocrm.com/?l=en_US#Lead");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btn-login']")));
        loginButton.click();

        WebElement createLeadButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='fas fa-plus fa-sm']/following-sibling::span")));
        createLeadButton.click();

        // Wait for the options to be visible and click on the 'Ms.' option
        WebElement Selectclick = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("div[class='selectize-input items has-options full has-items'] div[class='item']"))
        );
        Selectclick.click();

        WebElement selectption= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='item'][normalize-space()='Mr.']")));

        selectption.click();




        Thread.sleep(3000);
        driver.quit();
    }
}
