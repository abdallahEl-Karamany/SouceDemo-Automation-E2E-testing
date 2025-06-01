import POM.LoginPage;
import POM.OverviewPage;
import POM.ThanksPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OverviewPageTest extends BaseTest {
    @BeforeMethod
    @Parameters({"username", "password"})
    public void preconditions(String username, String password) {
        LoginPage login = new LoginPage();
        login.homeNavigation(URL);
        login.setUserName(username).setPassword(password).clickLoginButton()
                .addProductToCart("Sauce Labs Backpack")
                .addProductToCart("Sauce Labs Bike Light")
                .addProductToCart("Sauce Labs Bolt T-Shirt")
                .clickCartButton().clickCheckOutButton().setFirstName("Abdallah")
                .setLastName("El-Karamany").setZipCode("1235").clickContinueButton();
    }
    @Test
    public void historyCheck() {
        OverviewPage history = new OverviewPage();
        ThanksPage thank = new ThanksPage();

        Assert.assertEquals(history.getItemPrices(), history.getTotalPrice());
        history.clickFinishButton();
        Assert.assertEquals(thank.getThanksMessage(), "THANK YOU FOR YOUR ORDER");
        thank.clickMenuButton();
        thank.clickLogoutButton();
    }
}
