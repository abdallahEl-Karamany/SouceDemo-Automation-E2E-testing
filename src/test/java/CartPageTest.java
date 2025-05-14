import Actions.BrowserActions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalTime;

public class CartPageTest extends BaseTest {

    @Test
    public void cartValidation() {

        LocalTime cartq = LocalTime.now();
        System.out.println("cart"+cartq+" "+ BrowserActions.getDriver());
        cart.set(product.get().clickCartButton());
        Assert.assertNotNull(cart.get(), "cart page is null in CartValidation");

        Assert.assertEquals(cart.get().getCartItems(), 2, "Expected count in cart to be 2");
        cart.get().removeProductFromCart("Sauce Labs Bike Light");
        Assert.assertEquals(cart.get().getCartItems(), 1, "Expected count in cart to be 1");
        checkout.set(cart.get().clickCheckOutButton());


    }


}
