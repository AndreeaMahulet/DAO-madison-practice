package com.steps;

import com.dao.product.ProductAbstractDao;
import com.dao.product.ProductDao;
import com.dao.productreview.ProductReviewAbstractDao;
import com.dao.productreview.ProductReviewDao;
import com.models.Cart;
import com.models.Product;
import com.models.ProductReview;
import com.pages.ProductDetailsPage;
import com.tools.constants.SerenityKeyConstants;
import com.tools.utils.SerenitySessionUtils;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.List;

public class ProductDetailsSteps {
    private static final long serialVersionUID = 1L;
    private ProductDetailsPage productDetailsPage;
    private ProductAbstractDao productDao=new ProductDao();
    private ProductReviewAbstractDao productReviewDao=new ProductReviewDao();


    public Product getProductDetails(){
        Product product=new Product();
        product.setName(productDetailsPage.getProductName());
        product.setColor(productDetailsPage.getProductRandomColor());
        product.setSize(productDetailsPage.getProductRandomSize());
        product.setPrice(productDetailsPage.getPrice());
        return product;
    }
    @Step
    public void addProductToCart(int quantity){
        Product product=getProductDetails();
        productDetailsPage.typeInInputWithTitle("Qty",String.valueOf(quantity));
        product.setQty(quantity);
        product.setSubtotal(quantity*product.getPrice());
        productDetailsPage.clickOnWebElementWithText("Add to Cart");
        productDao.saveProduct(SerenityKeyConstants.CART_PRODUCTS_LIST,product);
    }

    @Step
    public void addProductReview(ProductReview productReview) {
//        ProductReview productReview = ProductReviewFactory.getProductReviewInstance(summary);
        //TODO complete the fields with data from productReview
        productDetailsPage.clickOnAddAReviewLink();
        productDetailsPage.setReviewCriteriaRows();
        productDetailsPage.fillInReviewDetails(productReview);
        productReviewDao.saveProductReview(productReview);
    }

    @Step
    public void addProductToWishList(int quantity) {
        Product product = getProductDetails();
        productDetailsPage.typeInInputWithTitle("Qty", String.valueOf(quantity));
        product.setQty(quantity);
        productDetailsPage.clickOnWebElementWithText("Add to Wishlist");
        productDao.saveProduct(SerenityKeyConstants.WISHLIST_PRODUCTS_LIST, product);
    }
    @Step
    public void clickOnSubmitReviewButton() {
        productDetailsPage.clickOnSubmitReviewButton();
    }
    @Step
    public void clickOnAddAReviewLink(){
        productDetailsPage.clickOnAddAReviewLink();
    }
    @Step
    public void verifyProductReview(String summary) {
        ProductReview expectedProductReview = new ProductReview((List<ProductReview>)SerenitySessionUtils.getFromSession(SerenityKeyConstants.PRODUCTS_REVIEWS));
        ProductReview actualProductReview = new ProductReview();
        actualProductReview.setProductReviews(productDetailsPage.getReviewsFromProductDetailPage());
        System.out.println("Expected review is: " + expectedProductReview.toString());
        System.out.println("Actual review is: " + actualProductReview.toString());
        Assert.assertTrue("Review details are not as expected!", expectedProductReview.equals(actualProductReview));
    }
}
