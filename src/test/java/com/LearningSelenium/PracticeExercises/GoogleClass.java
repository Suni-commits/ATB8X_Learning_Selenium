package com.LearningSelenium.PracticeExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class GoogleClass {

    @Test
    public void test() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.get("https://www.google.com/");

        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("computers");

        driver.findElement(By.xpath("//input[@role='button']")).click();

        Thread.sleep(3000);
        driver.quit();

    }
}
