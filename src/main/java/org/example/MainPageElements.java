package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPageElements {
    private WebDriver driver;

    public MainPageElements(WebDriver driver) {
        this.driver = driver;
    }

    // Локаторы элементов на главной странице
    private By accordionButtonLocator = By.id("accordion__heading-8");
    private By accordionTextLocator = By.cssSelector(".accordion__panel-8 p");


    // Методы для взаимодействия с элементами
    public void clickAccordionButton() {
        WebElement accordionButton = driver.findElement(accordionButtonLocator);
        accordionButton.click();
    }

    public String getAccordionText() {
        WebElement accordionTextElement = driver.findElement(accordionTextLocator);
        return accordionTextElement.getText();
    }



}

