package com.LearningSelenium.PracticingSelenium;

import org.testng.annotations.Test;

public class FirstTestCase {

    @Test
    public void test_openApp(){
        System.out.println("Opening the application");

    }

    @Test
    public void test_Loginapp(){
        System.out.println("Logging to the application");
    }

    @Test
    public void test_logoutapp(){
        System.out.println("Loggingout to the application");
    }

}
