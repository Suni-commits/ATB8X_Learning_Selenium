package com.LearningSelenium.Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Example026_WebTable02 {

        @Test
        public void test_WebTablemethod() {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://awesomeqa.com/webtable.html");

            String first_part = "//table[@id='customers']/tbody/tr[";
            String second_part = "]/td[";
            String third_part = "]";

            // Wait for the table to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customers")));

            // Corrected XPath expression to find rows
            int row = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
            // Corrected XPath expression to find columns
            int col = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td")).size();

            for (int i = 2; i <= row; i++) {
                for (int j = 1; j <= col; j++) {
                    String dynamic_path = first_part + i + second_part + j + third_part;
                    String data = driver.findElement(By.xpath(dynamic_path)).getText();

                    if (data.contains("Helen Bennett")) {
                        // Updated country column path based on the assumption
                        String country_path = first_part + i + second_part + (j + 1) + third_part;
                        String country_text = driver.findElement(By.xpath(country_path)).getText();
                        System.out.println("------------------");
                        System.out.println("Helen Bennett is In " + country_text);
                    }
                }
            }

            driver.quit();
        }
    }

