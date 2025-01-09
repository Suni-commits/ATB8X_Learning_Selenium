package com.LearningSelenium.Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.*;

public class Example025_WebTable01 {

    @Test
    public void test_webtables() throws InterruptedException {

        WebDriver driver=new EdgeDriver();
        driver.get("https://awesomeqa.com/webtable1.html");

        driver.manage().window().maximize();

        WebElement table= driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody"));

        List<WebElement> rows=table.findElements(By.tagName("tr"));


        for(int i=0;i<rows.size();i++){
            List<WebElement> col=rows.get(i).findElements(By.tagName("td"));
            for(WebElement c:col){
                System.out.println(c.getText());
            }
        }

            Thread.sleep(3000);

        driver.quit();

    }
}
