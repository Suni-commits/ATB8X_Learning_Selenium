package com.LearningSelenium.Learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Selenium02 {

    @Test
    void test_EdgebrowserOptions(){

        EdgeOptions edgeOptions=new EdgeOptions();
        edgeOptions.addArguments("--window-size=1920,1080");
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--headless--");

        WebDriver driver=new EdgeDriver(edgeOptions);
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.quit();

    }
}
