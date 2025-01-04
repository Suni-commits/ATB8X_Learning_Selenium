
package com.LearningSelenium.Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Handling_espoCRM {


    @Test
    public void Test01() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.us.espocrm.com/#");
        driver.manage().window().maximize();

//        Thread.sleep(3000);
//        WebElement create_button = driver.findElement(By.xpath("//a[@title='Ctrl+Space']"));
//        create_button.click();

        Thread.sleep(3000);
        driver.findElement(By.id("btn-login")).click();

        Thread.sleep(8000);
        driver.findElement(By.xpath("(//span[text()='Accounts'])[1]")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@title='Ctrl+Space']")).click();

        Thread.sleep(3000);

        WebElement input_name = driver.findElement(By.xpath("(//input[@class='main-element form-control'])[1]"));
        input_name.sendKeys("Vrushabh");

        WebElement input_mail = driver.findElement(By.xpath("//input[@class='form-control email-address']"));
        input_mail.sendKeys("vc@gmail.com");

        WebElement input_website = driver.findElement(By.xpath("(//input[@class='main-element form-control'])[2]"));
        input_website.sendKeys("vc.com");

        WebElement input_street = driver.findElement(By.xpath("//textarea[@data-name='billingAddressStreet']"));
        input_street.sendKeys("123, Street area, Juhu beach, Mumbai");

        WebElement input_state = driver.findElement(By.xpath("//input[@data-name='billingAddressState']"));
        input_state.sendKeys("Maharashtra");

        WebElement input_postcode = driver.findElement(By.xpath("//input[@data-name='billingAddressPostalCode']"));
        input_postcode.sendKeys("123456");

        WebElement input_country = driver.findElement(By.xpath("//input[@data-name='billingAddressCountry']"));
        input_country.sendKeys("India");

        //Click Save
        WebElement click_save = driver.findElement(By.xpath("//button[text()='Save']"));
        click_save.click();




        driver.quit();






    }
}
