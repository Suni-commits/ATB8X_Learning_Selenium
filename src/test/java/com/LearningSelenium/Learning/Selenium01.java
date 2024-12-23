package com.LearningSelenium.Learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Selenium01 {

    @Test
    void test_Browser() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.get("https://www.flipkart.com/");
        Thread.sleep(2000);

        driver.quit();
    }
}
