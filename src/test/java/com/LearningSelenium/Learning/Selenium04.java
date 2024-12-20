package com.LearningSelenium.Learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Selenium04 {

    @Test
    public void test_browser() throws InterruptedException {

        EdgeOptions edgeOptions=new EdgeOptions();

        edgeOptions.addArguments("--start-maximized");
        WebDriver driver=new EdgeDriver(edgeOptions);

        driver.get("https://chatgpt.com/");
        Thread.sleep(5000);

      //  driver.close();// it will close current window or tab

        driver.quit();// it will close all windows such as total browser

    }
}
