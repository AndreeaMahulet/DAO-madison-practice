package com.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.steps.StepEventBus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.InvocationTargetException;

@RunWith(SerenityRunner.class)
public class ManageWishlistProductsTest extends BaseTest{

    @Before
    public void dataPrep() {
        loginSteps.login();
        wishlistSteps.emptyWishlistIfIsNotAlreadyEmpty();
    }
    @Test
    public void manageWishlistProducts()throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
        productFlowSteps.addProductToWishlist("Chelsea Tee", 3);
        wishlistSteps.verifyWishListDetails();
        wishlistSteps.removeWishlistProduct("Chelsea Tee");
        wishlistSteps.emptyWishlist();
        wishlistSteps.verifyWishlistIsEmpty();
    }
    @Override
    @After
    public void tearDown() {
        StepEventBus.getEventBus().clearStepFailures();
        wishlistSteps.emptyWishlistIfIsNotAlreadyEmpty();
        webdriver.quit();
    }
}
