package com.LearningSelenium.PracticeExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class WebTableguruexample002 {

    @Test
    public void test() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.get("https://awesomeqa.com/webtable1.html");

        WebElement text=driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr/td[2]"));
        System.out.println(text.getText());

        Thread.sleep(3000);
        driver.quit();
    }
}
