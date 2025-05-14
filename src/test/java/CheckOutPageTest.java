import Actions.BrowserActions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalTime;

public class CheckOutPageTest extends BaseTest {


    @Test
    public void setFullInformation() {

        LocalTime check3 = LocalTime.now();

        System.out.println("check3"+check3+" "+ BrowserActions.getDriver());
        Assert.assertNotNull(checkout.get(), "checkout page is null in CartValidation");
        checkout.get().setFirstName("Abdallah").setLastName("El-Karamany").setZipCode("1235");
        history.set(checkout.get().clickContinueButton());
    }

    @Test
    public void setFirstNameOnly() {
        System.out.println("check1");
        Assert.assertNotNull(checkout.get(), "checkout page is null in CartValidation");

        checkout.get().setFirstName("Abdallah").clickContinueButton();
        Assert.assertEquals(checkout.get().getErrorMessage(), "Error: Last Name is required");

    }

    @Test
    public void leavePostalCodeEmpty() {
        System.out.println("check2");
        Assert.assertNotNull(checkout.get(), "checkout page is null in CartValidation");
        checkout.get().setLastName("El-Karamany").clickContinueButton();
        Assert.assertEquals(checkout.get().getErrorMessage(), "Error: Postal Code is required");
    }

}
