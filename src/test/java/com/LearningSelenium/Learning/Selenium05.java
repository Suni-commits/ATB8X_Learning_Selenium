package com.LearningSelenium.Learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Selenium05 {

    @Test
    public void test_methods(){

        WebDriver driver=new EdgeDriver();
        driver.get("https://sdet.live");

        driver.navigate().to("https://thetestingacademy.com");
        driver.navigate().back();
        driver.navigate().forward();
      System.out.println(driver.getTitle());
        driver.quit();
    }
}
