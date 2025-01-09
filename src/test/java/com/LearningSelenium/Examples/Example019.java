package com.LearningSelenium.Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;
import java.util.*;

public class Example019 {

    @Test
    public void test_multipleWindows() throws InterruptedException {

        EdgeOptions options=new EdgeOptions();
        options.addArguments("--guest");

        WebDriver driver=new EdgeDriver(options);

        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement clickhere= driver.findElement(By.linkText("Click Here"));
        clickhere.click();

        String parentwindow=driver.getWindowHandle();

        Set<String> windowHandles=driver.getWindowHandles();

        System.out.println("Windows handles "+windowHandles);

        for(String handle:windowHandles) {
            driver.switchTo().window(handle);

            if (driver.getPageSource().contains("New Window")) {
                System.out.println("Test Passed");

            }
            break;
        }
        Thread.sleep(3000);
        driver.quit();

    }

}
