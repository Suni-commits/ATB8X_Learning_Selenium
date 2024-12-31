import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Example07 {

    private WebDriver driver;
    private WebDriverWait wait;

    // Setup WebDriver and WebDriverWait before each test method
    @BeforeTest
    public void setup() {
        // Set up the WebDriver path
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");  // Replace with your path to chromedriver

        // Initialize the Chrome WebDriver
        driver = new ChromeDriver();

        // Initialize WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the login page
        driver.get("https://www.idrive360.com/enterprise/login");

        // Maximize the browser window
        driver.manage().window().maximize();
    }

    // Test method to perform login and check if "Free Trial" message is visible
    @Test
    public void testFreeTrialMessageVisible() {
        // Wait for the email field and enter email using XPath
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
        emailField.sendKeys("augtest_040823@idrive.com");

        // Enter password using XPath
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        passwordField.sendKeys("123456");

        // Click the login button using XPath
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // Wait for the free trial message and verify if it's visible using XPath
        WebElement freeTrialMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Free Trial')]")));

        // Assert that the Free Trial message is visible
        Assert.assertTrue(freeTrialMessage.isDisplayed(), "Free Trial message is not visible.");
    }

    // Cleanup method to close the browser after the test
    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
