package com.LearningSelenium.Learning;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class composemail {

    @Test
    public void test_compose(){
        WebDriver driver=new EdgeDriver();
        driver.get("https://www.flipkart.com/");
        driver.findElement(By.xpath("//a[@title='Cart']")).click();
        String message=driver.findElement(By.xpath("//div[@class='s2gOFd']")).getText();

        assertThat(message).isNotNull().isNotEmpty().isNotBlank();
        assertThat(message).isEqualTo("Missing Cart items?");
        driver.quit();


    }
}
