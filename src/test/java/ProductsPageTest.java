import Actions.BrowserActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalTime;

public class ProductsPageTest extends BaseTest {

    @Test
    public void addItemsToCart() {
        Assert.assertNotNull(product.get(), "Product page is null in addItemsToCart");
        SoftAssert softAssert = new SoftAssert();
        LocalTime products1 = LocalTime.now();

        System.out.println("products1"+ products1+" "+ BrowserActions.getDriver());

        product.get().addProductToCart("Sauce Labs Backpack");
        product.get().addProductToCart("Sauce Labs Bike Light");
        softAssert.assertEquals(product.get().getButtonText("REMOVE", "Sauce Labs Backpack"), "REMOVE");
        softAssert.assertEquals(product.get().getProductPrice("Sauce Labs Backpack"), "29.99", "Expected price is $29.99");
        softAssert.assertEquals(product.get().getProductPrice("Sauce Labs Bike Light"), "9.99", "Expected price is $9.99");
        softAssert.assertEquals(product.get().getCartItemCount(), "2", "Expected items count is 2");
        softAssert.assertAll();
    }

    @Test
    public void addItemThenRemove() {
        Assert.assertNotNull(product.get(), "Product page is null in addItemsThenRemove");
        SoftAssert softAssert = new SoftAssert();
        //System.out.println("cart2"+ product.get());
        product.get().addProductToCart("Sauce Labs Fleece Jacket");
        softAssert.assertEquals(product.get().getCartItemCount(), "3", "Expected items count is 3");
        product.get().removeProduct("Sauce Labs Fleece Jacket");
        softAssert.assertEquals(product.get().getButtonText("ADD", "Sauce Labs Fleece Jacket"), "ADD TO CART");

        softAssert.assertAll();
        //System.out.println("cart2");

    }
}
