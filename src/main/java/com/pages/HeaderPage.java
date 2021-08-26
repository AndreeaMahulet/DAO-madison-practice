package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderPage extends BasePage{
    public HeaderPage(WebDriver driver) {
        super(driver);
    }
    @org.openqa.selenium.support.FindBy(css = "#search")
    private WebElementFacade searchInput;
    @org.openqa.selenium.support.FindBy(css = "button[title='Search']")
    private WebElementFacade searchIcon;

    public void inputSearchTerm(String term) {
        typeInto(searchInput, term);
    }

    public void clickSearchIcon() {
        clickOn(searchIcon);
    }
    @org.openqa.selenium.support.FindBy(css="#nav li[class*='level0']")
    private List<WebElementFacade> categoryElements;

    @org.openqa.selenium.support.FindBy(css=".account-cart-wrapper a[class*='skip-account']")
    private WebElementFacade account;

    @FindBy(css=".account-cart-wrapper a[class*='skip-cart']")
    private WebElementFacade cart;

    public void clickOnAccount(){
        clickOn(account);
    }

    public void clickOnALinkFromAccount(String title){
        getDriver().findElement(By.cssSelector("#header-account .links ul li a[title='"+title+"']")).click();
    }

    public void clickOnCategory(String categoryName){
        for(WebElementFacade category:categoryElements){
            if(category.getText().equalsIgnoreCase(categoryName)){
                clickOn(category);
                break;
            }
        }
    }
}
