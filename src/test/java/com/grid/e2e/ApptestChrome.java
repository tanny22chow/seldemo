package com.grid.e2e;

import com.grid.BaseTest;
import com.grid.pageobjects.pageimpl.DemoPageImpl;
import com.grid.pageobjects.pages.DemoPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class ApptestChrome extends BaseTest {
    Logger logger= LoggerFactory.getLogger(this.getClass());
    @Test
    public void testWithChromeM1(){
        logger.info("logging from chrome test M1");
        DemoPage dm= DemoPageImpl.getPageInstance(d);
        dm.getSearchText();
    }
    @Test
    public void testWithChromeM2(){
        logger.info("logging from chrome test M2");
        DemoPage dm= DemoPageImpl.getPageInstance(d);
        dm.getSearchText();
    }
}
