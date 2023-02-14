package com.grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

public class DriverManager {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public WebDriver getDriver() {
        return driver;
    }

    private WebDriver driver;

    private DriverManager(String... browser) {
        try {
            if (browser.length == 0) {
                driver = new EdgeDriver();
            } else {
                switch (browser[0]) {
                    case "chrome":
//                    driver = new ChromeDriver();
                        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new ChromeOptions());
                        logger.info(String.format("chrome driver initiated with id %s", driver));
                        break;
                    case "firefox":
//                        driver = new FirefoxDriver();
                        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new FirefoxOptions());
                        logger.info(String.format("firefox driver initiated with id %s", driver));
                        break;
                    default:
//                        driver = new EdgeDriver();
                        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new EdgeOptions());
                        logger.info(String.format("default edge driver initiated with id %s", driver));
                        break;
                }
            }
        }catch (Exception e){
            logger.info("wrong remote driver url");
        }
    }

    public static WebDriver getInstance(String browser) {
        return new DriverManager(browser).getDriver();
    }
}
