package com.LearningSelenium.PracticeExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropdownExample1 {

    @Test
    public void test_dropdown() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/practice.html");

    WebElement drpop=driver.findElement(By.xpath("//select[@id='selenium_commands']/option[3]"));

        drpop.click();

        Thread.sleep(3000);
        driver.quit();

    }
}
