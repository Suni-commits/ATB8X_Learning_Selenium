package com.LearningSelenium.Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;
import java.util.*;

public class Example05 {

    @Test
    public void test_Method(){

        EdgeOptions options=new EdgeOptions();

        options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        WebDriver driver=new EdgeDriver(options);
        driver.get("https://app.vwo.com/#/login");

        //<div class="Mt(40px)" data-qa="qewoqoleka">
        //	Don&apos;t have an account?
        //	<a href="https://vwo.com/free-trial/?utm_medium=website&amp;utm_source=login-page&amp;utm_campaign=mof_eg_loginpage"
        //	class="text-link"
        //	data-qa="bericafeqo">Start a free trial</a>
        //	</div>

        WebElement link_text=driver.findElement(By.linkText("Start a free trial"));
        link_text.click();

        WebElement email=driver.findElement(By.id("page-v1-step1-email"));
        email.sendKeys("abc6654com");

        WebElement checkbox=driver.findElement(By.name("gdpr_consent_checkbox"));
        checkbox.click();

       List<WebElement> createfreeTrail= (List<WebElement>) driver.findElements(By.tagName("button"));
        createfreeTrail.get(0).click();

        WebElement error_message=driver.findElement(By.className("invalid-reason"));
        error_message.getText();

        driver.quit();

    }
}
