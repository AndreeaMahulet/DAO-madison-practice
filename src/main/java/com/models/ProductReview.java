package com.models;

import java.util.List;
import java.util.Objects;

public class ProductReview {
    private String summary;
    private String thoughts;
    private String nickname;
    private List<ProductReview> productReviews;
    private String criteria;
    private int nrStars;

    public ProductReview(){}

    public ProductReview(List<ProductReview> productReviews) {
        this.productReviews = productReviews;

    }
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getThoughts() {
        return thoughts;
    }

    public void setThoughts(String thoughts) {
        this.thoughts = thoughts;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setProductReviews(List<ProductReview> productReviews) {
        this.productReviews = productReviews;
    }

    public List<ProductReview> getProductReviews() {
        return productReviews;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public int getNrStars() {
        return nrStars;
    }

    public void setNrStars(int nrStars) {
        this.nrStars = nrStars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductReview that = (ProductReview) o;
        return nrStars == that.nrStars && Objects.equals(summary, that.summary) && Objects.equals(thoughts, that.thoughts) && Objects.equals(nickname, that.nickname) && Objects.equals(productReviews, that.productReviews) && Objects.equals(criteria, that.criteria);
    }

    @Override
    public String toString() {
        return "ProductReview{" +
                "summary='" + summary + '\'' +
                ", thoughts='" + thoughts + '\'' +
                ", nickname='" + nickname + '\'' +
                ", criteria='" + criteria + '\'' +
                ", nrStars=" + nrStars +
                '}';
    }

    //TODO define the rest of the fields

}
