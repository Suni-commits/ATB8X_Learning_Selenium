package com.LearningSelenium.PracticeExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import java.util.*;

public class WebTableGuruxamle002 {

    @Test
    public void test() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.get("https://demo.guru99.com/test/web-table-element.php");

        WebElement table=driver.findElement(By.xpath("//table[@class='dataTable']"));

        List<WebElement> rows=table.findElements(By.xpath("//tbody/tr"));
        System.out.println("No of rows : "+rows.size());

        boolean text=false;
        for(WebElement row:rows){
            List<WebElement> cols=rows.get(1).findElements(By.tagName("td"));

            for(WebElement col:cols){
                if(col.getText().equals("978")){
                    System.out.println(row.getText());
                    text=true;
                    break;
                }
            }
            if(text) break;
        }



        Thread.sleep(3000);
        driver.quit();

    }
}
