package com.steps.flowsteps;

import com.factories.ProductReviewFactory;
import com.steps.HeaderSteps;
import com.steps.ProductDetailsSteps;
import com.steps.ProductsSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class ProductFlowSteps  {
    private static final long serialVersionUID = 1L;
    @Steps
    private HeaderSteps headerSteps;
    @Steps
    private ProductsSteps productsSteps;
    @Steps
    private ProductDetailsSteps productDetailsSteps;
    @Step
    public void addProductToCart(String productName, int quantity){
        headerSteps.searchForProduct(productName);
        productsSteps.openProductDetailsPage(productName);
        productDetailsSteps.addProductToCart(3);
    }
    @Step
    public void addProductReview(String productName, String reviewSummary) {
        headerSteps.searchForProduct(productName);
        productsSteps.openProductDetailsPage(productName);
        productDetailsSteps.addProductReview(ProductReviewFactory.getProductReviewInstance());
    }

    @Step
    public void addProductToWishlist(String productName, int quantity) {
        headerSteps.searchForProduct(productName);
        productsSteps.openProductDetailsPage(productName);
        productDetailsSteps.addProductToWishList(3);
    }
    @Step
    public void addProductReview() {
        productDetailsSteps.addProductReview(ProductReviewFactory.getProductReviewInstance());
        productDetailsSteps.clickOnSubmitReviewButton();
    }
    @Step
    public void navigateToProductDetailsPage(String productName){
        headerSteps.searchForProduct(productName);
        productsSteps.openProductDetailsPage(productName);
    }

}
