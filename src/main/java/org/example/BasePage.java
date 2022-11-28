package org.example;
public class BasePage {
   protected static ThreadLocal<Object> threadSafePageObjects=new ThreadLocal<>();
}
