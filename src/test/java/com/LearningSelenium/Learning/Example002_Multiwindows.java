package com.LearningSelenium.Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.util.*;

public class Example002_Multiwindows {

    @Test
    public void test_multipleWindow() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1");
        driver.manage().window().maximize();

        String parentwindow=driver.getWindowHandle();
        System.out.println("Parent Window : " +parentwindow);

        Thread.sleep(5000);

        List<WebElement> view_hasmap= driver.findElements(By.cssSelector("[data-qa='meqeqiwiwe']"));

        Actions action=new Actions(driver);
        action.moveToElement(view_hasmap.get(1)).click().perform();
        Thread.sleep(14000);

        Set<String> windowhandles= driver.getWindowHandles();
        System.out.println("window handless :  "+windowhandles);




        for(String handles:windowhandles) {
            driver.switchTo().window(handles);

            if(driver.getPageSource().contains("Job Ready Automation Tester Blueprint with JAVA By Pramod Dutta")){
                System.out.println("Test PASSED");
                break;
            }
        }
        Thread.sleep(7000);
        driver.quit();


    }
}
