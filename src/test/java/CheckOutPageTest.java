import Actions.BrowserActions;
import POM.CheckOutPage;
import POM.LoginPage;
import POM.OverviewPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.LocalTime;

public class CheckOutPageTest extends BaseTest {
    @BeforeMethod
    @Parameters({"username", "password"})
    public void preconditions(String username, String password) {
        LoginPage login = new LoginPage();
        login.homeNavigation(URL);
        login.setUserName(username).setPassword(password).clickLoginButton()
                .addProductToCart("Sauce Labs Backpack")
                .addProductToCart("Sauce Labs Bike Light")
                .addProductToCart("Sauce Labs Bolt T-Shirt")
                .clickCartButton().clickCheckOutButton();
    }

    @Test
    public void setFullInformation() {


        CheckOutPage checkout = new CheckOutPage();
        Assert.assertEquals(checkout.getCheckOutPageTitle(), "Checkout: Your Information");
        checkout.setFirstName("Abdallah").setLastName("El-Karamany").setZipCode("1235");
        checkout.clickContinueButton();
        OverviewPage history= new OverviewPage();
        Assert.assertEquals(history.getHistoryPageTitle(), "Checkout: Overview","Expected history page title to be CHECKOUT: OVERVIEW");
    }

    @Test
    public void setFirstNameOnly() {

        CheckOutPage checkout = new CheckOutPage();

        checkout.setFirstName("Abdallah").clickContinueButton();
        Assert.assertEquals(checkout.getErrorMessage(), "Error: Last Name is required");

    }

    @Test
    public void leavePostalCodeEmpty() {
        CheckOutPage checkout = new CheckOutPage();
        Assert.assertNotNull(checkout, "checkout page is null in CartValidation");
        checkout.setFirstName("Abdallah").setLastName("El-Karamany").clickContinueButton();
        Assert.assertEquals(checkout.getErrorMessage(), "Error: Postal Code is required");
    }

}
