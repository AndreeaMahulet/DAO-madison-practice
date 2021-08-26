package com.dao.productreview;

import com.models.ProductReview;
import com.tools.constants.SerenityKeyConstants;
import com.tools.utils.SerenitySessionUtils;

import java.util.List;

public class ProductReviewDao implements ProductReviewAbstractDao {

    @Override
    public void saveProductReview(ProductReview productReview) {
        System.out.println("Saving product review having summary " + productReview.getSummary() + " ...");
        SerenitySessionUtils.saveObjectInSerenitySessionList(SerenityKeyConstants.PRODUCTS_REVIEWS, productReview);
    }

    @Override
    public ProductReview getReviewBySummary(String listName, String summary) {
        return getAllReviews(listName).parallelStream().filter(item -> item.getSummary().equalsIgnoreCase(summary)).findFirst().orElse(null);

    }

    public List<ProductReview> getAllReviews(String listName){
        return SerenitySessionUtils.getFromSession(listName);
    }
}
