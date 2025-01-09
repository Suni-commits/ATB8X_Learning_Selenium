package com.LearningSelenium.Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Example018 {

    @Test
    public void test_option(){
        WebDriver driver=new EdgeDriver();

        driver.get("https://awesomeqa.com/practice.html");

        WebElement Selecmd= driver.findElement(By.xpath("//select[@id='selenium_commands']/option[2]"));

        Selecmd.click();

        driver.quit();

    }

}
