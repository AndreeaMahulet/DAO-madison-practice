package com.steps;

import com.dao.product.ProductAbstractDao;
import com.dao.product.ProductDao;
import com.models.Product;
import com.models.Wishlist;
import com.pages.BasePage;
import com.pages.WishlistPage;
import com.tools.constants.SerenityKeyConstants;
import com.tools.utils.SerenitySessionUtils;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import javax.swing.plaf.PanelUI;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class WishlistSteps {
    private static final long serialVersionUID = 1L;
    private WishlistPage wishlistPage;
    private BasePage basePage;
    ProductAbstractDao productDao=new ProductDao();

    @Step
    public void emptyWishlistIfNotAlreadyEmpty(){
        basePage.clickOnWebElementWithText("Account");
        basePage.clickOnWebElementWithText("My Wishlist");
        wishlistPage.removeAllWishlistProducts();
    }
    @Step
    public void emptyWishlist() {
        wishlistPage.removeAllWishlistProducts();
    }
    @Step
    public void verifyWishlistIsEmpty() {
        Assert.assertTrue("Wishlist is not empty!", basePage.containsText("You have no items in your wishlist."));
    }

    @Step
    public void verifyWishListDetails() {
        @SuppressWarnings("unchecked")
        Wishlist expectedWishList = new Wishlist((List<Product>)SerenitySessionUtils.getFromSession(SerenityKeyConstants.WISHLIST_PRODUCTS_LIST));
        Wishlist actualWishList = new Wishlist();
        actualWishList.setWishlistProducts(wishlistPage.getProductsFromWishList());
        System.out.println("Expected wishlist is: " + expectedWishList.toString());
        System.out.println("Actual wishlist is: " + actualWishList.toString());
        Assert.assertTrue("Wishlist details are not as expected!", expectedWishList.equals(actualWishList));
    }
    @Step
    public void updateProductQuantity(String productName, int newQuantity) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Product product = productDao.getProductByName(SerenityKeyConstants.WISHLIST_PRODUCTS_LIST, productName);
        wishlistPage.updateProductQuantity(productName, newQuantity);
        product.setQty(newQuantity);
        productDao.updateProduct(SerenityKeyConstants.WISHLIST_PRODUCTS_LIST, product);
    }

    @Step
    public void removeWishlistProduct(String productName) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Product product = productDao.getProductByName(SerenityKeyConstants.WISHLIST_PRODUCTS_LIST, productName);
        wishlistPage.removeWishlistProduct(productName);
        productDao.removeProduct(SerenityKeyConstants.WISHLIST_PRODUCTS_LIST, product);
    }
    @Step
    public void emptyWishlistIfIsNotAlreadyEmpty() {
        basePage.clickOnWebElementWithText("Account");
        basePage.clickOnWebElementWithText("My Wishlist");
        wishlistPage.removeAllWishlistProducts();
    }


}
