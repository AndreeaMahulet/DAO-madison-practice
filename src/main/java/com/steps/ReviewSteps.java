package com.steps;

import com.pages.HeaderAdminPage;
import com.pages.ReviewsAdminPage;
import net.thucydides.core.annotations.Step;

public class ReviewSteps {
    private HeaderAdminPage headerAdminPage;
    private ReviewsAdminPage reviewsAdminPage;

    @Step
    public void navigateThroughCategories(String... pathNodes){
        headerAdminPage.navigateThroughCategories(pathNodes);
    }

    @Step
    public void approveReviewAsAdmin(String name, String status){
        reviewsAdminPage.clickOnPendingReview(name);
        reviewsAdminPage.approveReview(status);
        reviewsAdminPage.clickOnSaveReviewButton();

    }
}
