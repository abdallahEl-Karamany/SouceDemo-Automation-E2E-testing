import Actions.BrowserActions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.LocalTime;

public class LoginPageTest extends BaseTest {
    @Test(groups = "login-standard")
    @Parameters({"username", "password"})
    public void standardLogin(String username, String password) {
        LocalTime currentlogin1 = LocalTime.now();

        System.out.println("login"+currentlogin1+" "+BrowserActions.getDriver());
        product.set(login.get().setUserName(username).setPassword(password).clickLoginButton());
    }

    @Test
    @Parameters({"username", "password"})
    public void lockedOutLogin(String username, String password) {
        product.set(login.get().setUserName(username).setPassword(password).clickLoginButton());
        Assert.assertEquals(login.get().getErrorMessage(), "Epic sadface: Sorry, this user has been locked out.", "Error Message is Incorrect");
    }

    @Test
    @Parameters({"username", "password"})
    public void problemUserLogin(String username, String password) {
        product.set(login.get().setUserName(username).setPassword(password).clickLoginButton());
    }

    @Test
    @Parameters({"username", "password"})
    public void PerformanceGlitchLogin(String username, String password) {
        LocalTime currentlogin2 = LocalTime.now();
        System.out.println("loginper"+currentlogin2+" "+ BrowserActions.getDriver());

        product.set(login.get().setUserName(username).setPassword(password).clickLoginButton());
    }


}
