package com.dao.productreview;

import com.google.inject.ImplementedBy;
import com.models.ProductReview;

import java.util.List;

@ImplementedBy(ProductReviewDao.class)
public interface ProductReviewAbstractDao {
    public void saveProductReview(ProductReview productReview);
    public ProductReview getReviewBySummary(String listName, String summary);
    public List<ProductReview> getAllReviews(String listName);
}
