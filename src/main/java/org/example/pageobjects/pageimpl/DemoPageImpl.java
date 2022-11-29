package org.example.pageobjects.pageimpl;

import org.example.WebelementFactory;
import org.example.annotations.Search;
import org.example.pageobjects.pages.DemoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoPageImpl extends BasePage implements DemoPage {
    WebDriver d;
    public static DemoPage demopage;
    @Search(type = "id",val = "gsc-i-id1")
    public WebElement searchField;
    @Search(type = "xpath",val = "//h4[text()='Search for your Favorite Course']")
    public WebElement searchFieldText;

    private DemoPageImpl(WebDriver d){
        this.d=d;
        WebelementFactory.init(this,d);
    }
    public static DemoPage getPageInstance(WebDriver d){
        if(demopage!=null){
            return demopage;
        }
        demopage=new DemoPageImpl(d);
        threadSafePageObjects.set(demopage);
        return (DemoPage) threadSafePageObjects.get() ;
    }

    public DemoPage getSearchText(){
        System.out.println(searchFieldText.getText());
        searchField.sendKeys("java");
        return this;
    }
}
