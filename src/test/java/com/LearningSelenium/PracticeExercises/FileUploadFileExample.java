package com.LearningSelenium.PracticeExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class FileUploadFileExample {

    @Test
    public void test_FileUpload() throws InterruptedException {
        WebDriver driver=new EdgeDriver();

        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/selenium/upload.html");

        WebElement filetoUpoad=driver.findElement(By.id("fileToUpload"));

        String working_dir=System.getProperty("user.dir");

filetoUpoad.sendKeys(working_dir+"C://Users/Mohanshiva/Documents/New folder/ATB8X_Learning_Selenium/src/test/resources/TestData.txt");
        driver.findElement(By.name("submit")).click();

        Thread.sleep(3000);

        driver.quit();


    }
}
