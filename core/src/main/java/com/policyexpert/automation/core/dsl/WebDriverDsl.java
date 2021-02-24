package com.policyexpert.automation.core.dsl;

import com.policyexpert.automation.core.factory.BrowserFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class WebDriverDsl {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebDriverDsl.class);
    private static final long WAIT_TIMEOUT = 20;
    private static WebDriver driver = new BrowserFactory().getBrowser();

    private WebDriverDsl() {
    }


    public static void openUrl(String url) {
        driver.get(url);
    }

    public static void waitForNewPage(WebElement webElement) {
        waitForElementToBeVisible(webElement);
    }


    public static void fillText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public static String getText(WebElement element) {
        return element.getText();
    }


    public static void clickIfVisible(WebElement element) {
        if (isVisible(element)) {
            element.click();
        }
    }

    public static void clickUntilElementVisible(WebElement element) {
        new WebDriverWait(driver, WAIT_TIMEOUT).until(input -> clickWhenVisible(element));

    }

    public static void clickFromList(List<WebElement> elements, String language) {
        elements.stream().filter(f -> f.getText().contains(language)).findAny().ifPresent(WebElement::click);
    }

    public static void clickFromDropDownUntilElementIsVisible(List<WebElement> elements, WebElement conditionalElement, String language) {
        new WebDriverWait(driver, WAIT_TIMEOUT).until(input -> clickFromListAndVerifyElementIsVisible(elements, conditionalElement, language));
    }


    public static void waitForElementToBeVisible(WebElement element) {
        new WebDriverWait(driver, WAIT_TIMEOUT).until(input -> isVisible(element));
    }


    public static void WaitUntilSelectableAndSelect(WebElement element, String optionToSelect) {
        try {
            waitForElementToBeVisible(element);
            element.click();
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(optionToSelect);
        }
        catch(Exception e){
            LOGGER.debug("Dropdown could not be open!", e);
        }
    }


    private static boolean clickFromListAndVerifyElementIsVisible(List<WebElement> elements, WebElement conditionalElement, String value) {
        try {
            elements.stream().filter(f -> f.getText().contains(value)).findAny().ifPresent(WebElement::click);
        } catch (StaleElementReferenceException e) {
            return false;
        }
        return isVisible(conditionalElement);
    }

    private static boolean clickWhenVisible(WebElement element) {
        try {
            element.click();
            return true;
        } catch (StaleElementReferenceException |ElementClickInterceptedException e) {
            return false;
        }
    }


    private static boolean isVisible(WebElement element) {
        boolean retval;

        try {
            retval = element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            LOGGER.debug("Element was not found!", e);
            retval = false;
        }

        return retval;
    }

}
