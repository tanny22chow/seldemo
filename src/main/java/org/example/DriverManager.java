package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {

    private ThreadLocal<WebDriver> thredsafeDriverPool=new ThreadLocal<>();
    private static WebDriver d;

    private ThreadLocal<WebDriver> getThredsafeDriverPool() {
        return thredsafeDriverPool;
    }
    private DriverManager(){
        String browser=System.getProperty("browser");
        if(browser==null){
            d=new EdgeDriver();
        }else{
            switch (browser){
                case "chrome":
                    d=new ChromeDriver();
                    break;
                default:
                    d=new EdgeDriver();
                    break;
            }
        }
            thredsafeDriverPool.set(d);
        }
    public static WebDriver getInstance(){
       return new DriverManager().getThredsafeDriverPool().get();
    }
}
