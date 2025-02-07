package com.LearningSelenium.PracticeExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import java.util.*;

public class WebTableExample2 {

    @Test
    public void test() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.get("https://awesomeqa.com/webtable1.html");

        WebElement table= driver.findElement(By.tagName("Table"));

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
