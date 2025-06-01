import POM.LoginPage;
import POM.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class LoginPageTest extends BaseTest {


    @Test (dataProvider="loginData")
    public void standardLogin(String username, String password) {
       LoginPage login=new LoginPage();
        login.homeNavigation(URL);
        ProductsPage product=login.setUserName(username).setPassword(password).clickLoginButton();
        Assert.assertEquals(product.getPageLabelText(),"Products","User can't login successfully") ;
    }


    @DataProvider(name = "loginData" ,parallel = true)
    public Object[][] getLoginData()
    {
        return new Object[][]{{"standard_user","secret_sauce"}
                , {"problem_user","secret_sauce"}
                ,{ "performance_glitch_user","secret_sauce"}
                ,{" locked_out_user","secret_sauce"}

        };
    }

}
