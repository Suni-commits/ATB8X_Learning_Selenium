package com.LearningSelenium.Learning;

import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class Selenium06 {

    @Test
    void test_checkingHeading() throws Exception {

        EdgeOptions edgeOptions=new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver=new EdgeDriver(edgeOptions);
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        //validations using TestNg assertions

        Assert.assertEquals(driver.getTitle(),"CURA Healthcare Service");

        //Assert J
        assertThat(driver.getTitle()).isEqualTo("CURA Healthcare Service");
        assertThat(driver.getTitle()).isNotNull().isNotBlank();
        assertThat(driver.getCurrentUrl()).isEqualTo("https://katalon-demo-cura.herokuapp.com/");

        if(driver.getPageSource().contains("CURA Healthcare Service")){
            Assert.assertTrue(true);
        }
        else {
            throw  new Exception("Heading does not exist");
        }

        Thread.sleep(3000);

        driver.quit();


    }
}
