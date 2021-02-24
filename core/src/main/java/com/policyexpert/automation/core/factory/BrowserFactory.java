package com.policyexpert.automation.core.factory;


import com.policyexpert.automation.core.model.BrowserManager;
import org.openqa.selenium.WebDriver;


public class BrowserFactory {


    /**
     *
     * @return instantiate and return driver
     */
    public WebDriver initBrowser() {
        return BrowserManager.getInstance().getDriver(BrowserConfigFactory.initConfig());
    }

    /**
     *
     * @return instantiated driver
     */
    public WebDriver getBrowser() {
        return BrowserManager.getInstance().getInstantiatedDriver();
    }

    /**
     * quit the driver
     */
    public void quitBrowser() {
        BrowserManager.getInstance().destroyDriver();
    }
}
