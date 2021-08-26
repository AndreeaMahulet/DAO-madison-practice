package com.pages;

import com.models.User;
import com.tools.constants.EnvironmentConstants;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver){
        super(driver);
    }
    @FindBy(css=".registered-users h2")
    private WebElementFacade loginMsg;

    @FindBy(css=".my-account h1")
    private WebElementFacade loggedInMsg;

    @FindBy(name="send")
    private WebElementFacade loginBtn;

    public String getLoginMsg(){
        return loginMsg.getText();
    }
    public void clickOnLoginBtn(){
        clickOn(loginBtn);
    }
    public String getLoggedInMsg(){
        return loggedInMsg.getText();
    }
    public void fillUserDetailsLogin(User user){
        populateInputField("login[username]", user.getEmail());
        populateInputField("login[password]", user.getPassword());
    }
    public void login() {
        clickOnWebElementWithText("Account");
        clickOnWebElementWithText("Log In");
        typeInInputWithTitle("Email Address", EnvironmentConstants.EMAIL);
        typeInInputWithTitle("Password", EnvironmentConstants.PASS);
        clickOnWebElementWithText("Login");
    }
}