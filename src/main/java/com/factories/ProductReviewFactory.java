package com.factories;

import com.models.ProductReview;
import net.bytebuddy.utility.RandomString;

public class ProductReviewFactory {
    public static ProductReview getProductReviewInstance() {
        ProductReview productReview = new ProductReview();
        productReview.setSummary(RandomString.make(10));
        productReview.setThoughts(RandomString.make(10));
        productReview.setNickname(RandomString.make(10));
        return productReview;
    }
}
