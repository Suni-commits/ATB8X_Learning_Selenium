package com.LearningSelenium.ParallelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class ParamTest_switch01 {

    WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    void setUp(String br){

        switch(br){
            case "chrome" :driver=new ChromeDriver();break;
            case "edge" :driver=new EdgeDriver();break;
            case "firefox" :driver=new FirefoxDriver();break;
            default:System.out.println("browser not a valid");return;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://app.vwo.com/#/login");

    }

    @Test
    public void test_LoginPage() throws InterruptedException {
        Thread.sleep(2000);
       driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("abc@test.com");
        driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("abc@23");
        driver.findElement(By.xpath("//button[@id='js-login-btn']")).click();
        Thread.sleep(3000);
        WebElement err_text=driver.findElement(By.xpath("//div[@id='js-notification-box-msg']"));
         String err_msg=err_text.getText();

         System.out.println(err_msg);

         assertThat(err_msg).isNotBlank().isNotNull().isNotEmpty();
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }

}


