package com.mydemo.stepdefinitions;

import com.mydemo.pages.CalculatorButton;
import com.mydemo.pages.HomePage;
import com.mydemo.utils.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CalculatorSteps {
    WebDriver driver = DriverManager.getDriver();
    HomePage homePage;


    @Before
    public void setup() {
        DriverManager.setupDriver();
        driver = DriverManager.getDriver();
        homePage = new HomePage(driver);
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }

    @Given("I navigate to home page")
    public void iNavigateToHomePage() {
        driver.get("https://web2.0calc.com");
    }

 
    @ParameterType(".*")
    public CalculatorButton calculatorButton(@org.jetbrains.annotations.NotNull String button) {
        return CalculatorButton.valueOf(button.toUpperCase());
    }
   @When("I press button {}")
   public void iPressButton(CalculatorButton button) {
       WebElement buttonElement = homePage.getButton(button);
       System.out.println("Button Element: " + buttonElement);
       buttonElement.click();
   }

    @Then("the page title should be {string}")
    public void thePageTitleShouldBe(String title) {
        Assert.assertEquals(homePage.getPageTitle().trim(), title);
    }

    @Then("I open the history dropdown")
    public void iOpenTheHistoryDropdown() {
        homePage.openHistoryDropdown();
    }

//    @Then("I close the browser")
//    public void iCloseTheBrowser() {
//        DriverManager.quitDriver();
//    }

    @ParameterType("should|should not")
    public String condition(String condition) {
        return condition;
    }
    @Then("the result {condition} be {float}")
    public void theResultShouldOrShouldNotBe(String condition, Float value) {
        float result = homePage.getFirstResultHistory();
        switch (condition) {
            case "should":
                Assert.assertEquals(result, value);
                break;
            case "should not":
                Assert.assertNotEquals(result, value);
                break;
            default:
                throw new IllegalArgumentException("Invalid condition: " + condition + ". Use 'should' or 'should not'.");
        }
    }
}
