package com.mydemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

public class HomePage {
    WebDriver driver;

    private Map<CalculatorButton, WebElement> buttonMap = new HashMap<>();

    @FindBy(tagName = "title")
    WebElement pageTitle;

    @FindBy(id = "Btn1")
    WebElement ONE;

    @FindBy(id = "Btn2")
    WebElement TWO;

    @FindBy(id = "Btn3")
    WebElement THREE;

    @FindBy(id = "Btn0")
    WebElement ZERO;

    @FindBy(id = "BtnPlus")
    WebElement PLUS;

    @FindBy(id = "BtnMinus")
    WebElement MINUS;

    @FindBy(id = "BtnMult")
    WebElement MULTIPLY;

    @FindBy(id = "BtnParanL")
    WebElement LEFT_PARENTHESIS;

    @FindBy(id = "BtnParanR")
    WebElement RIGHT_PARENTHESIS;

    @FindBy(id = "BtnSin")
    WebElement SIN;

    @FindBy(id = "BtnCalc")
    WebElement EQUAL;

    @FindBy(css = "#hist .btn.dropdown-toggle")
    WebElement historyDropdownToggle;

    @FindBy(css = "#histframe li:nth-child(1) p.r")
    WebElement firstResultHistory;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        buttonMap.put(CalculatorButton.ONE, ONE);
        buttonMap.put(CalculatorButton.TWO, TWO);
        buttonMap.put(CalculatorButton.THREE, THREE);
        buttonMap.put(CalculatorButton.ZERO, ZERO);
        buttonMap.put(CalculatorButton.PLUS, PLUS);
        buttonMap.put(CalculatorButton.MINUS, MINUS);
        buttonMap.put(CalculatorButton.MULTIPLY, MULTIPLY);
        buttonMap.put(CalculatorButton.LEFT_PARENTHESIS, LEFT_PARENTHESIS);
        buttonMap.put(CalculatorButton.RIGHT_PARENTHESIS, RIGHT_PARENTHESIS);
        buttonMap.put(CalculatorButton.SIN, SIN);
        buttonMap.put(CalculatorButton.EQUAL, EQUAL);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public WebElement getButton(CalculatorButton button) {
        return buttonMap.get(button);
    }

    public void openHistoryDropdown() {
        historyDropdownToggle.click();
    }

    public Float getFirstResultHistory() {
        String result = firstResultHistory.getAttribute("title");
        System.out.println("Result: " + result);
        return Float.parseFloat(result);
    }

}