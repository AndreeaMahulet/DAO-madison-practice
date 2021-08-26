package com.tests;
import com.tools.constants.Constants;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.lang.reflect.InvocationTargetException;

@RunWith(SerenityRunner.class)
public class ManageCartProductsTest extends BaseTest{
    @Test
    public void test001ManageGuestCartProducts() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
//        productFlowSteps.addProductToCart("Chelsea Tee", 3);
        productFlowSteps.addProductToCart("Slim fit Dobby Oxford Shirt", 2);
        cartSteps.verifyCartWithPercentageTaxesDetails(Constants.CART_TAX_RATE);

        cartSteps.updateCartProductQuantity("Slim fit Dobby Oxford Shirt", 10);
//        cartSteps.verifyCartWithPercentageTaxesDetails(Constants.CART_TAX_RATE);

        cartSteps.removeCartProduct("Chelsea Tee");
//        cartSteps.verifyCartWithPercentageTaxesDetails(Constants.CART_TAX_RATE);

        cartSteps.emptyCart();
        cartSteps.verifyCartIsEmpty();

    }
}
