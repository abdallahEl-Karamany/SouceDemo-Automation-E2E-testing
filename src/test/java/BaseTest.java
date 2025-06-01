import Actions.BrowserActions;
import POM.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {




    String URL="https://www.saucedemo.com/v1/";
    @BeforeMethod
    public void setUp() {
        BrowserActions.webDriverInit(BrowserActions.browser.chrome);
        BrowserActions.windowMaximize();
    }

    @AfterMethod
    public void tearDown() {
        BrowserActions.closeBrowser();

    }

}
