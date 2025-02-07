package com.LearningSelenium.PracticeExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import java.util.*;

public class Example01 {

    WebDriver driver;

    @Test
    void test_webtable(){

        driver=new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        driver.manage().window().maximize();

       WebElement table=driver.findElement(By.id("table1"));
      List <WebElement> rows=driver.findElements(By.tagName("tr"));

      for(int i=0;i<rows.size();i++){
          List <WebElement> col=rows.get(i).findElements(By.tagName("td"));
         for(WebElement c:col){
             System.out.println(c.getText());
         }
      }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();


    }

}
