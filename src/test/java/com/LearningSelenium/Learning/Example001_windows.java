package com.LearningSelenium.Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import java.util.*;

public class Example001_windows {

    @Test
    public void test_windowsHndles() throws Exception {
        WebDriver driver=new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");

        String parentwindow= driver.getWindowHandle();

        WebElement linktext=driver.findElement(By.linkText("Click Here"));
        linktext.click();

        Set<String> windowhandle=driver.getWindowHandles();
        System.out.println("window handle "+windowhandle);


        for(String handle:windowhandle) {

            driver.switchTo().window(handle);

            if (driver.getPageSource().contains("New Window")) {
                System.out.println("Test Is Passed");
                break;
            }
        }

        Thread.sleep(3000);

        driver.quit();

    }
}
