package com.policyexpert.automation.core.factory;

import com.policyexpert.automation.core.config.ConfigResolver;
import com.policyexpert.automation.core.model.BrowserConfig;


public class BrowserConfigFactory {

    private static final String DRIVER_TYPE = ConfigResolver.getConfig().getString("browser.type");
    private static final String URL = ConfigResolver.getConfig().getString("browser.remote_uri");

    private BrowserConfigFactory() {
    }

    /**
     * @return the Browser Config depending on the browser choice
     */
    static BrowserConfig initConfig() {
        return getInitChromeConfig();
    }


    private static BrowserConfig getInitChromeConfig() {
        return BrowserConfig.newBuilder().withDriverType(DRIVER_TYPE).withUrl(URL)
                .build();
    }


}
