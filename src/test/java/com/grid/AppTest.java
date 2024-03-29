package com.grid;

import com.grid.pageobjects.pages.DemoPage;
import com.grid.pageobjects.pageimpl.DemoPageImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.util.concurrent.*;


public class AppTest extends BaseTest {
    Logger logger= LoggerFactory.getLogger(this.getClass());
  @Test
    public void test1WithFirefox(){
      logger.info("logging from test");
   DemoPage dm= DemoPageImpl.getPageInstance(d);
    dm.getSearchText();
  }
    @Test
    public void test2WithFirefox(){
        logger.info("logging from test");
        DemoPage dm= DemoPageImpl.getPageInstance(d);
        dm.getSearchText();
    }

//  public void m12(){
//      Map<String, Integer> map=new HashMap<String,Integer>();
//      map.put("basant",5000);
//      map.put("santosh",16000);
//      map.put("javed",12000);
//      map.put("emil",212000);
//
//     List<String> l1=Arrays.asList(new String[]{"tan","Zen","Dono"});
//
//      map.entrySet().stream().filter(en-> en.getValue()>10000)
//              .collect(Collectors.toList()).stream()
//              .map(en->en.getKey())
//              .collect(Collectors.toList());
////              .forEach(System.out::println);
//      l1.stream().sorted(Comparator.comparing(e->e)).forEach(System.out::println);
//      map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue))
//                              .forEach(en-> System.out.println(en.getKey()+">>>>>>"+en.getValue()));
//      try {
//          Files.lines(Path.of(""));
//      }catch (Exception e){
//
//      }
//      map.computeIfPresent("basant",(k,v)->v+12);
//      map.forEach((k,v)->System.out.println(k+">>>>>>"+v));
//  }
  public void AsyncMethod() throws Exception {

      ExecutorService pool=Executors.newFixedThreadPool(2);
      CompletableFuture<String> future1=CompletableFuture.supplyAsync(()->{
          try {
              TimeUnit.SECONDS.sleep(2);
          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          }
          return " first async resp "+Thread.currentThread().getName() +"\n";
      },pool).thenApplyAsync(s1-> s1+" second added resp "+Thread.currentThread().getName()+"\n",pool)
              .thenApplyAsync(s2-> s2+" added third resp "+Thread.currentThread().getName()+"\n",pool)
              .thenApplyAsync(s4-> s4+" final resp "+Thread.currentThread().getName()+"\n");
  }
  @Test(enabled = false)
  public void m13(){
      try {
          TimeUnit.SECONDS.sleep(5);
      } catch (InterruptedException e) {
          throw new RuntimeException(e);
      }
      System.out.println("m13 in main thread");
  }




}
