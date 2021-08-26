package com.steps;

import com.pages.ProductsPage;
import net.thucydides.core.annotations.Step;

public class ProductsSteps{
    private static final long serialVersionUID = 1L;
    private ProductsPage productsPage;
    @Step
    public void openProductDetailsPage(String productName){
        productsPage.openProductDetailsPage(productName);
    }
}
