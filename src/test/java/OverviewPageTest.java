import org.testng.Assert;
import org.testng.annotations.Test;

public class OverviewPageTest extends BaseTest {
    @Test
    public void historyCheck() {
        System.out.println("history");
        Assert.assertNotNull(history.get(), "overview page is null in historycheck");
        Assert.assertEquals(history.get().getItemPrices(), history.get().getTotalPrice());
        thank.set(history.get().clickFinishButton());
        Assert.assertEquals(thank.get().getThanksMessage(), "THANK YOU FOR YOUR ORDER");
    }
}
