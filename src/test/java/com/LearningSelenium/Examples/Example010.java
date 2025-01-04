package com.LearningSelenium.Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Example010 {

    @Test
    public void test_navigationtoBrowser() throws InterruptedException {

        EdgeOptions options=new EdgeOptions();

        options.addArguments("--start-maximized");

       WebDriver driver=new EdgeDriver(options);

       driver.get("https://www.opencart.com/");

       // checking title

        String title=driver.getTitle();

        System.out.println("the page title : "+title);

        Thread.sleep(2000);

        WebElement element=driver.findElement(By.xpath("//a[@class='navbar-brand']"));
        String test=element.getTagName();
        System.out.println("The page element is : "+ test);
        driver.quit();

    }
}
