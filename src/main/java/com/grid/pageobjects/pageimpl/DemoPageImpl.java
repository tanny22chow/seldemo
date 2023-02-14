package com.grid.pageobjects.pageimpl;

import com.grid.WebelementFactory;
import com.grid.annotations.Search;
import com.grid.pageobjects.pages.DemoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DemoPageImpl extends BasePage implements DemoPage {

    Logger logger= LoggerFactory.getLogger(this.getClass());
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
        demopage=new DemoPageImpl(d);
        return demopage;
    }

    public DemoPage getSearchText(){
        logger.info("entering keys in the field");
        searchField.sendKeys("java");
        return this;
    }
}
