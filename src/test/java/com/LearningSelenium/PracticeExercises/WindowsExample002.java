package com.LearningSelenium.PracticeExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import java.util.*;

import java.time.Duration;

public class WindowsExample002 {

    @Test
    public void test_windows() throws InterruptedException {

        WebDriver driver=new EdgeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://the-internet.herokuapp.com/windows");

        String parentwindow=driver.getWindowHandle();
        System.out.println("The Parent window is : "+parentwindow);

      driver.findElement(By.linkText("Click Here")).click();

        Set<String> allwindows=driver.getWindowHandles();
        System.out.println("child window is "+allwindows);

        for(String winodw:allwindows){
            driver.switchTo().window(winodw);
            if(driver.getPageSource().contains("New Window")){
                System.out.println("Test Passed");
                break;
            }
        }
        Thread.sleep(3000);
        driver.quit();

    }
}
