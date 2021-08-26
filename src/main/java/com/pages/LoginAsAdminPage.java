package com.pages;

import com.tools.constants.EnvironmentConstants;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public class LoginAsAdminPage extends BasePage{

    public LoginAsAdminPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#message-popup-window > div.message-popup-head > a")
    private WebElementFacade popupMessage;
    @FindBy(css = "input[value='Login']")
    private WebElementFacade loginButton;

    public void navigateToAdminLoginPage(){
        getDriver().get(EnvironmentConstants.ADMIN_URL);
    }
    public void loginAsAdmin(){
        typeInInputWithId("username", EnvironmentConstants.ADMINEMAIL);
        typeInInputWithId("login", EnvironmentConstants.ADMINPASS);
        clickLoginButton();
    }
    public void clickLoginButton() {
        clickOn(loginButton);
    }
    public void closePopupMessage(){
        clickOn(popupMessage);
    }
}
