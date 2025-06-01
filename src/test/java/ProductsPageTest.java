import POM.LoginPage;
import POM.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class ProductsPageTest extends BaseTest {

@BeforeMethod
@Parameters({"username", "password"})
public void login(String username, String password){
    LoginPage login = new LoginPage();
    login.homeNavigation(URL);
    login.setUserName(username).setPassword(password).clickLoginButton();

}
    @Test
    public void addItemsToCart() {
        ProductsPage product =new ProductsPage();
        SoftAssert softAssert = new SoftAssert();
        Assert.assertEquals(product.getPageLabelText(), "Products", "Expected to return to products page");
        product.addProductToCart("Sauce Labs Backpack");
        product.addProductToCart("Sauce Labs Bike Light");
        product.addProductToCart("Sauce Labs Bolt T-Shirt");
        softAssert.assertEquals(product.getButtonText("REMOVE", "Sauce Labs Backpack"), "REMOVE", "expected button text to be REMOVE");
        softAssert.assertEquals(product.getButtonText("REMOVE", "Sauce Labs Bike Light"), "REMOVE");
        softAssert.assertEquals(product.getButtonText("REMOVE", "Sauce Labs Bolt T-Shirt"), "REMOVE");
        softAssert.assertEquals(product.getProductPrice("Sauce Labs Backpack"), "29.99", "Expected price is $29.99");
        softAssert.assertEquals(product.getProductPrice("Sauce Labs Bike Light"), "9.99", "Expected price is $9.99");
        softAssert.assertEquals(product.getCartItemCount(), "3", "Expected items count is 3");
        softAssert.assertAll();
    }

    @Test
    public void addItemThenRemove() {

        SoftAssert softAssert = new SoftAssert();
        ProductsPage product =new ProductsPage();
        product.addProductToCart("Sauce Labs Backpack");
        product.addProductToCart("Sauce Labs Bike Light");
        softAssert.assertEquals(product.getCartItemCount(), "2", "Expected items count is 2");
        product.removeProduct("Sauce Labs Backpack");
        softAssert.assertEquals(product.getButtonText("ADD", "Sauce Labs Backpack"), "ADD TO CART", "expected button text to be ADD TO CART");
        softAssert.assertAll();
    }

}
