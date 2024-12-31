package com.LearningSelenium.Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;
import java.util.*;



public class Selenium07 {

    @Test
    public void test_searchitem() throws InterruptedException {

        EdgeOptions options=new EdgeOptions();

        options.addArguments("--start-maximized");

        WebDriver driver=new EdgeDriver(options);

        driver.get("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");

        WebElement searchBox=driver.findElement(By.xpath("//input[@id='gh-ac']"));
                searchBox.sendKeys("Dell Windows");

                WebElement searchButton=driver.findElement(By.xpath("//input[@id='gh-btn']"));

                searchButton.click();

                List <WebElement> productTitle= driver.findElements(By.xpath("//div[@class='s-item__title']"));
                List <WebElement> productPrices=driver.findElements(By.xpath("//span[@class='s-item__price']"));

                int size= Math.min(productTitle.size(), productPrices.size());

                for(int i=0;i<size;i++){
                    System.out.println("Title  " +productTitle.get(i).getText() + " || " + productPrices.get(i).getText() );
                }

                Thread.sleep(4000);

                driver.quit();


    }
}
