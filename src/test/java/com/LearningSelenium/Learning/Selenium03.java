package com.LearningSelenium.Learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class Selenium03 {
    @Test
    public void test_browser(){
        ChromeOptions Options=new ChromeOptions();
        Options.addExtensions(new File("src/test/java/com/LearningSelenium/Learning/adblock.crx"));

        WebDriver driver=new ChromeDriver(Options);

        driver.get("https://www.youtube.com/");
        driver.quit();

    }
}
