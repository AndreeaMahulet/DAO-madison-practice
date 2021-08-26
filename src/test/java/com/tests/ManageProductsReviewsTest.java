package com.tests;

import com.steps.LoginAdminSteps;
import com.steps.ProductDetailsSteps;
import com.steps.ReviewSteps;
import net.bytebuddy.utility.RandomString;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.InvocationTargetException;
@RunWith(SerenityRunner.class)

public class ManageProductsReviewsTest extends BaseTest{
        private String summaryReview = RandomString.make(10);
        @Steps
        private LoginAdminSteps loginAdminSteps;
        @Steps
        private ReviewSteps reviewSteps;
        @Steps
        private ProductDetailsSteps productDetailsSteps;
        @Before
        public void dataPrep() {
            loginSteps.login();
        }

        @Test
        public void test003ManageProductsReviews() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            productFlowSteps.navigateToProductDetailsPage("Houston Travel Wallet");
            productFlowSteps.addProductReview();
            loginAdminSteps.navigateToAdminLoginPage();
            loginAdminSteps.loginAsAdmin();
            reviewSteps.navigateThroughCategories("Catalog", "Reviews and Ratings", "Customer Reviews", "Pending Reviews");
            reviewSteps.approveReviewAsAdmin("Houston Travel Wallet", "Approved");
            setup();
            productFlowSteps.navigateToProductDetailsPage("Houston Travel Wallet");
            productDetailsSteps.clickOnAddAReviewLink();
            productDetailsSteps.verifyProductReview(summaryReview);
        }

        @Override
        public void tearDown() {
            //ideally, here you could remove the review from admin
        }

}
