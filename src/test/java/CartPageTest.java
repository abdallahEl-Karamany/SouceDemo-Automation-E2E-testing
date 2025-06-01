import POM.CartPage;
import POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class CartPageTest extends BaseTest {

    @BeforeMethod
    @Parameters({"username", "password"})
    public void preconditions(String username, String password) {
        LoginPage login = new LoginPage();
        login.homeNavigation(URL);
        login.setUserName(username).setPassword(password).clickLoginButton()
        .addProductToCart("Sauce Labs Backpack")
        .addProductToCart("Sauce Labs Bike Light")
        .addProductToCart("Sauce Labs Bolt T-Shirt")
        .clickCartButton();
    }
    @Test
    public void cartValidation() {


        CartPage cart = new CartPage();
        Assert.assertEquals(cart.getCartPageTitle(), "Your Cart", "Expected cart page title to be YOUR CART"); cart.getCartPageTitle();
        Assert.assertEquals(cart.getCartItems(), 3, "Expected count in cart to be 3");
        cart.removeProductFromCart("Sauce Labs Bike Light");
        Assert.assertEquals(cart.getCartItems(), 2, "Expected count in cart to be 1");
        cart.clickCheckOutButton();
    }
}

