package com.LearningSelenium.DataDrivenTestingExample;

import com.LearningSelenium.Utils.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class FDCalculator extends ExcelUtils {

    @Test
    public void test_FixedDepositCalculation() throws IOException, InterruptedException {
        EdgeOptions options=new EdgeOptions();
        options.addArguments("--guest");
        options.addArguments("--start-maximized");
        WebDriver driver=new EdgeDriver(options);
        driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");

        String filepath=System.getProperty("user.dir")+"//src/test/resources/FDCalcuator.xlsx";

        int rows=ExcelUtils.getRowCount(filepath,"sheet1");

     for(int i=1;i<=rows;i++){
         //Step1 : read data from excel
       String princ=ExcelUtils.getCellData(filepath,"sheet1",i,0);
       String ROI=ExcelUtils.getCellData(filepath,"Sheet1",i,1);
       String period1=ExcelUtils.getCellData(filepath,"Sheet1",i,2);
       String period2=ExcelUtils.getCellData(filepath,"Sheet1",i,3);
       String Fre=ExcelUtils.getCellData(filepath,"Sheet1",i,4);
       String exp_mval=ExcelUtils.getCellData(filepath,"Sheet1",i,5);

       //Step2: pass above data into application
         driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(princ);
         driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(ROI);
         driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(period1);
        Select predropdown = new Select (driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
        predropdown.selectByVisibleText(period2);

        Select fedropdown=new Select(driver.findElement(By.xpath("//select[@id='frequency']")));

        fedropdown.selectByVisibleText(Fre);

         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("wzrk-overlay")));


         driver.findElement(By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']")).click();
       String act_mval= driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();

        if(Double.parseDouble(exp_mval)==Double.parseDouble(act_mval)){
            System.out.println("Test Passed");
            ExcelUtils.setCellData(filepath,"sheet1",i,7,"Passed");
            ExcelUtils.fillGreenColor(filepath,"sheet1",i,7);
         }
        else {
            System.out.println("Test Failed");
            ExcelUtils.setCellData(filepath, "sheet1", i, 7, "Failed");
            ExcelUtils.fillRedColor(filepath, "sheet1", i, 7);
        }
        Thread.sleep(4000);
         driver.findElement(By.xpath("//img[@class='PL5']")).click();
     }
        driver.quit();
    }
}
