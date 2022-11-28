package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {

    public static WebDriver d;
    private DriverManager(){
        if(d==null){
            d=new EdgeDriver();
        }
    }
    public static WebDriver getInstance(){
        new DriverManager();
        return d;
    }
}
