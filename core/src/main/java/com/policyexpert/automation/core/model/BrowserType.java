package com.policyexpert.automation.core.model;


import com.policyexpert.automation.core.exceptions.policyexpertWebException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public enum BrowserType {

    CHROME {
        @Override
        protected WebDriver createWebDriver(BrowserConfig config) {

            try {
                return new RemoteWebDriver(new URL(config.getUrl()), DesiredCapabilities.chrome());
            } catch (MalformedURLException e) {
                throw new policyexpertWebException("Cannot Instantiate new Driver", e);
            }

        }
    };

    /**
     * Creates the web driver.
     *
     * @return the web driver
     */
    protected abstract WebDriver createWebDriver(BrowserConfig config);

}
