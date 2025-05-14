import Actions.BrowserActions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalTime;

public class InventoryPageTest extends BaseTest {

    @Test
    public void addItemFromInv() {
        LocalTime invent = LocalTime.now();
        System.out.println("inv"+invent+" "+ BrowserActions.getDriver());

        inv.set( product.get().clickProductIcon("Sauce Labs Onesie"));

        Assert.assertEquals(inv.get().getProductName(), "Sauce Labs Onesie");
        inv.get().clickAddToCart();
        Assert.assertEquals(inv.get().getButtonText("REMOVE"), "REMOVE");
        inv.get().clickRemoveButton();
        Assert.assertEquals(inv.get().getButtonText("ADD"), "ADD TO CART");
        product.set(inv.get().clickBackButton());
    }
}
