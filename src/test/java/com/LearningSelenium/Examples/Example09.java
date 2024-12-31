package com.LearningSelenium.Examples;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Example09 {

    @Description("TC_01 : Verifying search box in chrome browser")
    @Test
    public void test_searchtext(){

        ChromeOptions options=new ChromeOptions();

        options.addArguments("--start-maximized");

        WebDriver driver=new ChromeDriver(options);

        driver.get("https://www.google.com/");

        WebElement searchbox=driver.findElement(By.xpath("//textarea[@id='APjFqb']"));

        searchbox.sendKeys("chatgpt");

        WebElement searchButton=driver.findElement(By.xpath("//input[@name='btnK']"));

        searchButton.click();

        driver.quit();


    }
}
