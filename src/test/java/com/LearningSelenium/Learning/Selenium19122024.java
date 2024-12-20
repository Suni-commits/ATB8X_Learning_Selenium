package com.LearningSelenium.Learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Selenium19122024 {

   // @Test
    void test_openedgeBrowser(){

        WebDriver driver=new EdgeDriver();
        driver.get("https://www.google.com/");
        driver.quit();
    }

  //  @Test
    void test_openChromebrowser(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://fakeapi.platzi.com/en/rest/products/");
        driver.quit();
    }

}
