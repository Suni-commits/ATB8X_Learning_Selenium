package com.LearningSelenium.Learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class Selenium03 {
    @Test
    public void test_browser(){
        EdgeOptions edgeOptions=new EdgeOptions();
        edgeOptions.addExtensions(new File("src/test/java/com/LearningSelenium/Learning/adblock.crx"));

        WebDriver driver=new EdgeDriver(edgeOptions);

        driver.get("https://www.youtube.com/");
        driver.quit();

    }
}
