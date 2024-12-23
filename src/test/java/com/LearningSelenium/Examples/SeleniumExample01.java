package com.LearningSelenium.Examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SeleniumExample01 {

    @Test
    void test_chromedriver() throws Exception {

        ChromeOptions options =new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://www.nextgenerationautomation.com/post/selenium-coding-exercises");

        assertThat(driver.getTitle()).isEqualTo("Selenium Coding Exercises");

        if(driver.getPageSource().contains("Selenium Coding Exercises")){
            Assert.assertTrue(true);
            System.out.println("The tile of the page is Selenium Coding Exercises");
        }
        else {
            throw new Exception("Title does not exist");
        }

        driver.quit();
    }
}
