package org.example;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public WebDriver d;

    @BeforeTest
    public void setup(){
        d= DriverManager.getInstance();
        d.get("https://www.guru99.com/");
        d.manage().window().maximize();
    }
    @AfterTest
    public void teardown(){
        d.quit();
    }
}
