import Actions.BrowserActions;
import POM.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.LocalTime;

public class BaseTest {

    protected static ThreadLocal<LoginPage> login = new ThreadLocal<>();
    protected static ThreadLocal<ProductsPage> product = new ThreadLocal<>();
    protected static ThreadLocal<InventoryPage> inv = new ThreadLocal<>();
    protected static ThreadLocal<CartPage> cart = new ThreadLocal<>();
    protected static ThreadLocal<CheckOutPage> checkout = new ThreadLocal<>();
    protected static ThreadLocal<OverviewPage> history = new ThreadLocal<>();
    protected static ThreadLocal<ThanksPage> thank = new ThreadLocal<>();


    @BeforeTest
    public void setUp() {


        BrowserActions.webDriverInit(BrowserActions.browser.chrome);
        BrowserActions.windowMaximize();
        login.set(new LoginPage());
        login.get().homeNavigation();
        System.out.println(BrowserActions.getDriver());
        LocalTime currentTime = LocalTime.now();
        System.out.println("BeforeTest"+currentTime+" "+BrowserActions.getDriver());
    }

    @AfterTest
    public void tearDown() {
        BrowserActions.closeBrowser();
        login.remove();
        product.remove();
        cart.remove();
        checkout.remove();
        history.remove();
        inv.remove();
        thank.remove();
    }

}
