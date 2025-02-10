package com.LearningSelenium.PracticeExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropdownExample003 {

/*   @Test
    public void test() throws InterruptedException {
       WebDriver driver=new EdgeDriver();
       driver.manage().window().maximize();
       driver.get("file://C:/Users/Mohanshiva/Desktop/dropdown.html");

       Select dropvalue=new Select(driver.findElement(By.id("cars")));

       dropvalue.selectByIndex(2);

       Thread.sleep(4000);
       driver.quit();

    } */

    @Test
    public void test() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select dropvalue=new Select(driver.findElement(By.id("dropdown")));

        dropvalue.selectByVisibleText("Option 1");
        System.out.println(dropvalue.getOptions().size());

        Thread.sleep(4000);
        driver.quit();

    }
}
