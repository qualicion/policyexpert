package com.policyexpert.automation;


import com.policyexpert.automation.core.factory.BrowserFactory;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        monochrome = true,
        features = "src/test/resources/features",
        tags = "@policy"
)


public class CucumberRunner extends AbstractTestNGCucumberTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(CucumberRunner.class);

    private static BrowserFactory getBrowserFactory() {
        return new BrowserFactory();
    }

    @BeforeSuite
    public void startSuite() {
        getBrowserFactory().initBrowser();
        LOGGER.info("Test Suite Started");
    }

    @AfterSuite
    public void stopSuite() {
        getBrowserFactory().quitBrowser();
        LOGGER.info("Test Suite Ended");
    }
}
