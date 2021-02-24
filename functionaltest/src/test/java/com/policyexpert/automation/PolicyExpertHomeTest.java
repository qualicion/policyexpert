package com.policyexpert.automation;

import com.policyexpert.automation.core.dsl.WebDriverDsl;
import com.policyexpert.automation.core.factory.BrowserFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.policyexpert.automation.core.dsl.WebDriverDsl.*;


public class PolicyExpertHomeTest {
    private static final String URL = "https://insurance.policyexpert.co.uk/home";

    @FindBy(css = "[class$='title'] > div > div > select")
    private WebElement title;
    @FindBy(css = "[class$='first-name'] > div > div > input")
    private WebElement firstName;
    @FindBy(css = "[class$='last-name'] > div > div > input")
    private WebElement lastName;
    @FindBy(css = "[class$='your-date-of'] > div > div > div > div:first-child > select")
    private WebElement day;
    @FindBy(css = "[class$='your-date-of'] > div > div > div > div:nth-child(2) > select")
    private WebElement month;
    @FindBy(css = "[class$='your-date-of'] > div > div > div > div:last-child > select")
    private WebElement year;
    @FindBy(css ="[class$='marital'] > div > div > select")
    private WebElement maritalStatus;
    @FindBy(css = "[class$='-occupat'] > div > div > div > input")
    private WebElement occupation;
    @FindBy(css = "[class$='-living'] > div > div > div > div > button:first-child")
    private WebElement doYouSmoke;
    @FindBy(css = "[class$='telephone-numbe'] > div > div > input")
    private WebElement telephoneNumber;
    @FindBy(css = "[class$='e-mail'] > div > div > input")
    private WebElement email;
    @FindBy(css = "[class$='with-th'] > div > div > div > div > button:first-child")
    private WebElement giveConsent;
    @FindBy(css = "[class$='-property'] > div > div > div > div > div > div > input")
    private WebElement address;


    public PolicyExpertHomeTest() {
        BrowserFactory browserFactory = new BrowserFactory();
        browserFactory.initBrowser();
        PageFactory.initElements(browserFactory.getBrowser(), this);
    }


    @Given("^i am on the details page$")
    public void i_am_on_the_details_page() {
        WebDriverDsl.openUrl(URL);
        waitForElementToBeVisible(title);
    }

    @When("^i fill the form and submit$")
    public void i_fill_the_form_and_submit(DataTable dataTable) {
        List<String> details = dataTable.asList();

        WaitUntilSelectableAndSelect(title, details.get(0));
        fillText(firstName, details.get(1));
        fillText(lastName, details.get(2));
        WaitUntilSelectableAndSelect(day, details.get(3));
        WaitUntilSelectableAndSelect(month, details.get(4));
        WaitUntilSelectableAndSelect(year, details.get(5));
        WaitUntilSelectableAndSelect(maritalStatus, details.get(6));
        fillText(occupation, details.get(7));
        clickUntilElementVisible(doYouSmoke);
        fillText(telephoneNumber, details.get(8));
        fillText(email, details.get(9));
        clickUntilElementVisible(giveConsent);
        fillText(address, details.get(10));

        //click on compare quotes

    }

    @Then("^i should be on the quotes page$")
    public void i_should_be_on_the_quotes_page() throws Throwable {
        //Verify you are on the quotes page

    }
}
