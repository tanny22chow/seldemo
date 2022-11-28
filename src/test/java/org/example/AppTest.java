package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;


public class AppTest extends BaseTest {

@Test
  public void m11(){
   DemoPage dm=DemoPage.getPageInstance(d);
    dm.getSearchText();
  }

  public void m12(){
      Map<String, Integer> map=new HashMap<String,Integer>();
      map.put("basant",5000);
      map.put("santosh",16000);
      map.put("javed",12000);
      map.put("emil",212000);

     List<String> l1=Arrays.asList(new String[]{"tan","Zen","Dono"});

      map.entrySet().stream().filter(en-> en.getValue()>10000)
              .collect(Collectors.toList()).stream()
              .map(en->en.getKey())
              .collect(Collectors.toList());
//              .forEach(System.out::println);
      l1.stream().sorted(Comparator.comparing(e->e)).forEach(e->System.out.println(e));
      map.entrySet().stream().sorted(Comparator.comparing(en->en.getValue()))
                              .forEach(en->{
                                  System.out.println(en.getKey()+">>>>>>"+en.getValue());
                              });
      try {
          Files.lines(Path.of(""));
      }catch (Exception e){
          
      }
//      map.computeIfPresent("basant",(k,v)->v+12);
//      map.forEach((k,v)->System.out.println(k+">>>>>>"+v));
  }



  public void AsyncMethod() throws InterruptedException, ExecutionException, TimeoutException {

      ExecutorService pool=Executors.newFixedThreadPool(2);
       AtomicReference<String> finalstr= new AtomicReference<String>("");
      CompletableFuture future1=CompletableFuture.supplyAsync(()->{
          try {
              TimeUnit.SECONDS.sleep(5);
          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          }
          return " first async resp "+Thread.currentThread().getName() +"\n";
      },pool).thenApplyAsync(s1->{
          return s1+" second added resp "+Thread.currentThread().getName()+"\n";
      },pool).thenApplyAsync(s2->{
          return s2+" added third resp "+Thread.currentThread().getName()+"\n";
      },pool).thenApplyAsync(s4->{
          return s4+" final resp "+Thread.currentThread().getName()+"\n";
      });
   //   System.out.println(future1.join());

  }

  @Test
  public void m13(){
      System.out.println("m13 in main thread");
  }


}
