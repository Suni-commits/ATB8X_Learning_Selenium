package com.LearningSelenium.PracticeExercises;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TakingScvreenShot {

    @Test
        public  void takeScreenshot(WebDriver driver, String fileName) throws IOException {
            // Cast WebDriver to TakesScreenshot interface
            TakesScreenshot ts = (TakesScreenshot) driver;

            // Capture the screenshot as a File object
            File sourceFile = ts.getScreenshotAs(OutputType.FILE);

            // Specify the destination file path
            File destinationFile = new File("path/to/save/" + fileName + ".png");

            // Save the screenshot
            FileHandler.copy(sourceFile, destinationFile);
        }
    }

