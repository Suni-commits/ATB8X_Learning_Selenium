package com.LearningSelenium.PracticeExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.util.*;

public class WindowsHandlingexample {

    @Test
    public void windowmehtod() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1");

        String parentWindow= driver.getWindowHandle();
        System.out.println("Parent window is : " +parentWindow);

        List<WebElement> element= driver.findElements(By.xpath("//div[@data-qa='yedexafobi']"));

        Actions action=new Actions(driver);
        action.moveToElement(element.get(1)).click().perform();

        Set<String> alwindowhandle=driver.getWindowHandles();
        System.out.println("All windows are : "+alwindowhandle);

        for(String windowhandle:alwindowhandle){
            if(!windowhandle.equals(parentWindow)){
                driver.switchTo().window(windowhandle);
                driver.switchTo().frame("heatmap-iframe");

                WebElement clickmap=driver.findElement(By.xpath("//span[@data-qa='refoyekife']"));
                clickmap.click();
            }
        }

        Thread.sleep(14000);
        driver.quit();

    }
}
