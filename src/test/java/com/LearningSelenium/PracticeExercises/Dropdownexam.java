package com.LearningSelenium.PracticeExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Dropdownexam {

    @Test
    public void test() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("file://C:/Users/Mohanshiva/Desktop/dropdown.html");
        driver.findElement(By.xpath("//select[@id='cars']/option[2]")).click();

        Thread.sleep(4000);
        driver.quit();
    }
}
