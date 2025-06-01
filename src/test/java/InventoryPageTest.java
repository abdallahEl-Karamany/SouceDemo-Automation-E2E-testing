import POM.InventoryPage;
import POM.LoginPage;
import POM.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class InventoryPageTest extends BaseTest {
    @BeforeMethod
    @Parameters({"username", "password"})
    public void login(String username, String password) {
        LoginPage login = new LoginPage();
        login.homeNavigation(URL);
        login.setUserName(username).setPassword(password).clickLoginButton();

    }

    @Test
    public void addItemFromInv() {
        InventoryPage inv = new InventoryPage();
        inv.clickProductIcon("Sauce Labs Onesie");

        Assert.assertEquals(inv.getProductName(), "Sauce Labs Onesie");
        inv.clickAddToCart();
        Assert.assertEquals(inv.getButtonText("REMOVE"), "REMOVE");
        inv.clickRemoveButton();
        Assert.assertEquals(inv.getButtonText("ADD"), "ADD TO CART");
        ProductsPage product=inv.clickBackButton();
        Assert.assertEquals(product.getPageLabelText(), "Products", "Expected to return to products page");
    }
}
