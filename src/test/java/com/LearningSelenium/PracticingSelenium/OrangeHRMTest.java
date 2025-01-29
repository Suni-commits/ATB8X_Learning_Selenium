package com.LearningSelenium.PracticingSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class OrangeHRMTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Initialize WebDriver once for all tests
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        // Perform login if not already logged in
        if (!isUserLoggedIn()) {
            login();
        }
    }

    public void login() {
        // Login credentials
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        // Wait for the dashboard to confirm login
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[normalize-space()='Dashboard']")));
    }

    public boolean isUserLoggedIn() {
        // Check if dashboard is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[normalize-space()='Dashboard']")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Test
    public void test_Imageortext() {
        // Test after login to verify image text
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String imageText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='oxd-userdropdown-img']"))).getAttribute("alt");
        assertThat(imageText).isNotBlank();  // Verifying image alt text
    }

    @Test
    public void test_LogoutORHapp() {
        // Test logout functionality after login
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();

        // Verify that we're back at the login page
        wait.until(ExpectedConditions.urlContains("auth/login"));
    }

    @AfterClass
    public void tearDown() {
        // Quit WebDriver after all tests
        if (driver != null) {
            driver.quit();
        }
    }
}
