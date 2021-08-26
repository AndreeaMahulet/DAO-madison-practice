package com.tests;

import com.factories.UserFactory;
import com.steps.LoginSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class LoginTest extends BaseTest{
    @Steps
    public LoginSteps loginSteps;

    @Test
    public void loginTest(){
        loginSteps.goToLogin();
        loginSteps.loginUser(UserFactory.getUserCredentials());
    }
}
