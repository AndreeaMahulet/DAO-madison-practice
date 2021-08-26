package com.steps;

import com.dao.registration.UserAbstractDao;
import com.dao.registration.UserDao;
import com.models.User;
import com.pages.HeaderPage;
import com.pages.LoginPage;
import com.tools.constants.MessageConstants;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;


public class LoginSteps {
    private static final long serialVersionUID = 1L;
    private LoginPage loginPage;
    private HeaderPage headerPage;
    private UserAbstractDao userDao = new UserDao();
    @Step
    public void goToLogin(){
        headerPage.clickOnAccount();
        headerPage.clickOnALinkFromAccount("Log In");
        Assert.assertTrue(loginPage.getLoginMsg().equalsIgnoreCase(MessageConstants.loginMsg));
    }

    @Step
    public void loginUser(User user){
        System.out.println(user);
        loginPage.fillUserDetailsLogin(user);
        loginPage.clickOnLoginBtn();
        Assert.assertEquals(loginPage.getLoggedInMsg(), MessageConstants.loggedInMsg);
        userDao.saveLoggedInUser(user);

    }
    @Step
    public void login() {
        loginPage.login();
    }


}
