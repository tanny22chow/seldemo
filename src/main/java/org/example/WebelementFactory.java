package org.example;

import org.example.annotations.Search;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.lang.reflect.Field;
import java.time.Duration;

public class WebelementFactory {
    public static void init(Object obj, WebDriver d){
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        try{
            for(Field f:obj.getClass().getDeclaredFields()){
                if(f.isAnnotationPresent(Search.class)){
                    f.setAccessible(true);
                    switch (f.getAnnotation(Search.class).type()){
                        case "xpath":
                            String s=f.getAnnotation(Search.class).val();
                            try {
                                f.set(obj,d.findElement(By.xpath(s)));
                            }catch (Exception e){
                                f.set(obj,null);
                            }
                            break;
                        case "id":
                            String s1=f.getAnnotation(Search.class).val();
                            try {
                                f.set(obj,d.findElement(By.id(s1)));
                            }catch (Exception e){
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
