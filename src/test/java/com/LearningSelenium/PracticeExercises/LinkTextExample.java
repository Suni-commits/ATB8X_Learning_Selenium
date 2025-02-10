package com.LearningSelenium.PracticeExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class LinkTextExample {

    @Test
    public void test_example001() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");

        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Login"));

        Thread.sleep(6000);

        driver.quit();

    }
}
