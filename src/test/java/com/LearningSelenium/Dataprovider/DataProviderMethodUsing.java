package com.LearningSelenium.Dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.fail;
import static org.testng.AssertJUnit.assertTrue;

public class DataProviderMethodUsing {

    WebDriver driver;

    @BeforeMethod
    void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");

    }

    @Test(dataProvider="dp")
    public void Test_Login(String email,String pwd) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pwd);
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Thread.sleep(4000);

        boolean status = driver.findElement(By.xpath("//span[normalize-space()='My Account']")).isDisplayed();
       if(status==true) {
           driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
           Assert.assertTrue(true);
       }
       else{
           Assert.fail();
       }

    }


    @AfterMethod
    void tearDown() {
        driver.quit();

    }

    @DataProvider(name="dp")
    public Object[][] loginData(){

        Object data[][] ={
                {"abcs123@gmail.com","password"},
                {"test123@test.com","test23"},
                {"ram123@test.com","test23"},
                {"testsuni@gmail.com","test@123"},
                {"Mestst123@test.com","test23"},
        };


        return data;

    }



}
