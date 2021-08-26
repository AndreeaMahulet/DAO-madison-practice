package com.steps;

import com.pages.HeaderPage;
import net.thucydides.core.annotations.Step;

public class HeaderSteps {
    private static final long serialVersionUID = 1L;
    private HeaderPage headerPage;

    @Step
    public void searchForProduct(String productName){
        headerPage.inputSearchTerm(productName);
        headerPage.clickSearchIcon();
    }
}
