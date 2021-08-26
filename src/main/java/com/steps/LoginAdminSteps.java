package com.steps;

import com.pages.LoginAsAdminPage;
import net.thucydides.core.annotations.Step;

public class LoginAdminSteps {
    private LoginAsAdminPage loginAsAdminPage;
    @Step
    public void navigateToAdminLoginPage(){
        loginAsAdminPage.navigateToAdminLoginPage();
    }

    @Step
    public void loginAsAdmin(){
        loginAsAdminPage.loginAsAdmin();
        loginAsAdminPage.closePopupMessage();
    }
}
