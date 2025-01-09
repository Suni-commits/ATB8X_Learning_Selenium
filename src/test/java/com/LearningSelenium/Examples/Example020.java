package com.LearningSelenium.Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.*;

public class Example020 {

    @Test
    public void test_MultipleWindowsHandles() throws InterruptedException {

        EdgeOptions options=new EdgeOptions();

        options.addArguments("--guest");

        WebDriver driver=new EdgeDriver(options);

        driver.get("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1");
        driver.manage().window().maximize();

        Set<String> parentwindow=driver.getWindowHandles();
        System.out.println("parent--> "+parentwindow);

        List<WebElement> multipleawindows=driver.findElements(By.cssSelector("[data-qa='meqeqiwiwe']"));

        Actions action=new Actions(driver);
        action.moveToElement(multipleawindows.get(1)).click().perform();

        Thread.sleep(14000);



        driver.quit();

    }
}
