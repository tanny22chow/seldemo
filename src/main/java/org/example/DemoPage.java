package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoPage {
    WebDriver d;
    public static DemoPage demopage;
    @Search(type = "id",val = "gsc-i-id1")
    public WebElement searchField;
    @Search(type = "xpath",val = "//h4[text()='Search for your Favorite Course']")
    public WebElement searchFieldText;

    private DemoPage(WebDriver d){
        this.d=d;
        WebelementFactory.init(this,d);
    }
    public static DemoPage getPageInstance(WebDriver d){
        if(demopage!=null){
            return demopage;
        }
        demopage= new DemoPage(d);
        return demopage;
    }

    public DemoPage getSearchText(){
        System.out.println(searchFieldText.getText());
        searchField.sendKeys("java");
        return this;
    }
}
