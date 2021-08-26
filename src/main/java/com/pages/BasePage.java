package com.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class BasePage extends PageObject {
    public BasePage(final WebDriver driver) {
        super();
    }


    public void populateInputField(String name, String value){
        typeInto(getDriver().findElement(By.cssSelector("input[name='"+name+"']")),value);
    }
    public WebElement getRandomElementFromList(By by){
        List<WebElement> elements=getDriver().findElements(by);
        Random rand=new Random();
        return elements.get(rand.nextInt(elements.size()));
    }
    public WebElement getWebElementWithText(String text) {
        List<WebElement> elements = getDriver().findElements(By.xpath("//*[text()='" + text + "']"));
        return elements.stream().filter(element -> element.isDisplayed()).findFirst()
                .orElse(getDriver().findElement(By.xpath("//*[contains(text(),'" + text + "')]")));
    }

    public void typeInInputWithTitle(String inputTitle, String value) {
        typeInto(getDriver().findElement(By.cssSelector("input[title='" + inputTitle + "']")), value);
    }
    public void clickOnWebElementWithText(String text) {
        clickOn(getWebElementWithText(text));
    }

    public void typeInInputWithId(String inputId, String value) {
        typeInto(getDriver().findElement(By.cssSelector("input[id='" + inputId + "']")), value);
    }
    public void typeInInputWithName(String inputName, String value){
        typeInto(getDriver().findElement(By.cssSelector("textarea[name='" + inputName + "']")), value);
    }
}
