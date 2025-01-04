package com.LearningSelenium.Examples;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import org.testng.annotations.Test;



public class Exampe012 {

    @Description("TC_01 : Verifying Error message if not provided any data")
    @Test
    public void test_Errormessage() throws InterruptedException {

        // Set Edge options and maximize window
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");

        // Initialize the WebDriver for Edge
        WebDriver driver = new EdgeDriver(options);

        // Open the EspoCRM URL
        driver.get("https://demo.us.espocrm.com/?l=en_US#Account");

        Thread.sleep(3000);

        // Wait for the username dropdown and select 'admin'
        WebElement usernamedropdown = driver.findElement(By.xpath("//select[@id='field-userName']"));
        usernamedropdown.click();

        Thread.sleep(9000);
        WebElement usernameoption = driver.findElement(By.xpath("//option[@value='admin']"));
        usernameoption.click();

        Thread.sleep(8000);

        // Click the login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='btn-login']"));
        loginButton.click();

        Thread.sleep(9000);

        // click on Create Button

        WebElement createAccountbutton = driver.findElement(By.xpath("//span[@class='fas fa-plus fa-sm']/following-sibling::span"));

        createAccountbutton.click();

        Thread.sleep(3000);
        WebElement saveButton=driver.findElement(By.xpath("//button[@data-name='save']"));
        saveButton.click();

        Thread.sleep(9000);
       WebElement nametext=driver.findElement(By.xpath("//input[@data-name='name']"));

       nametext.sendKeys("AutomaticMachineUser");

        WebElement emailText=driver.findElement(By.xpath("//input[@class='form-control email-address']"));

            emailText.sendKeys("test76544@gmail.com");

        WebElement websiteText=driver.findElement(By.xpath("//input[@data-name='website']"));

        websiteText.sendKeys("https://testbook.com");

        WebElement officephone=driver.findElement(By.xpath("//input[@autocomplete='espo-phoneNumber']"));

        officephone.sendKeys("447709872");

        WebElement BillingStreet=driver.findElement(By.xpath("//textarea[@data-name='billingAddressStreet']"));

        BillingStreet.sendKeys("Gandimaisamma");

        WebElement BillingCity=driver.findElement(By.xpath("//input[@data-name='billingAddressCity']"));

        BillingCity.sendKeys("Dundigal");

        WebElement BillingState=driver.findElement(By.xpath("//input[@data-name='billingAddressState']"));

        BillingState.sendKeys("Hyderabad");

        WebElement BillingPinCode=driver.findElement(By.xpath("//input[@data-name='billingAddressPostalCode']"));

        BillingPinCode.sendKeys("500043");

        WebElement BillingCountry=driver.findElement(By.xpath("//input[@data-name='billingAddressCountry']"));

        BillingCountry.sendKeys("India");

        WebElement ShippingAddressStreet=driver.findElement(By.xpath("//textarea[@data-name='shippingAddressStreet']"));

        ShippingAddressStreet.sendKeys("Gandimaisamma");


        WebElement ShippingCity=driver.findElement(By.xpath("//input[@data-name='shippingAddressCity']"));

        ShippingCity.sendKeys("Dundigal");

        WebElement ShippingState=driver.findElement(By.xpath("//input[@data-name='shippingAddressState']"));

        ShippingState.sendKeys("Hyderabad");

        WebElement ShippingPinCode=driver.findElement(By.xpath("//input[@data-name='shippingAddressPostalCode']"));

        ShippingPinCode.sendKeys("500043");

        WebElement ShippingCountry=driver.findElement(By.xpath("//input[@data-name='shippingAddressCountry']"));

        ShippingCountry.sendKeys("India");

        Thread.sleep(2000);

        WebElement save1Button=driver.findElement(By.xpath("//button[@data-action='save']"));
        save1Button.click();

        Thread.sleep(4000);


        // For now, just quit the driver
        driver.quit();

    }
}
