package com.grid;

import com.grid.annotations.Search;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.time.Duration;

public class WebelementFactory {
    static Logger logger= LoggerFactory.getLogger(WebelementFactory.class);
    public static void init(Object obj, WebDriver d){
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        try{
            for(Field f:obj.getClass().getDeclaredFields()){
                if(f.isAnnotationPresent(Search.class)){
                    f.setAccessible(true);
                    switch (f.getAnnotation(Search.class).type()){
                        case "xpath":
                            String s=f.getAnnotation(Search.class).val();
                            logger.info(String.format("Finding element with xpath %s",s));
                            try {
                                f.set(obj,d.findElement(By.xpath(s)));
                            }catch (Exception e){
                                logger.info(String.format("Element Not found with xpath %s",s));
                                f.set(obj,null);
                            }
                            break;
                        case "id":
                            String s1=f.getAnnotation(Search.class).val();
                            logger.info(String.format("Finding element with id %s",s1));
                            try {
                                f.set(obj,d.findElement(By.id(s1)));
                            }catch (Exception e){
                                logger.info(String.format("Element Not found with id %s",s1));
                                f.set(obj,null);
                            }
                            break;
                    }
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
