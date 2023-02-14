package com.grid;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

public class BaseTest {
    Logger logger= LoggerFactory.getLogger(this.getClass());
    public WebDriver d;
    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser){
        d= DriverManager.getInstance(browser);
        logger.info("Find Landing page");
        d.get("https://www.guru99.com/");
        d.manage().window().maximize();
    }
    @AfterMethod
    public void teardown(){
        logger.info("Driver tear down"+d);
        d.quit();
    }
}
