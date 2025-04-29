import Actions.BrowserActions;
import POM.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    LoginPage login;
    ProductsPage product=null;
    CartPage cart;
    CheckOutPage checkout;
    OverviewPage history;
    InventoryPage inv;
    ThanksPage thank;
    @BeforeTest
    public void setUp(){

        BrowserActions.webDriverInit(BrowserActions.browser.chrome);
        BrowserActions.windowMaximize();
        login=new LoginPage();
        login.homeNavigation();
    }

    @AfterTest
    public void tearDown() {
        BrowserActions.closeBrowser();
    }

    @Test
    @Parameters({"username", "password"})
    public void standardLogin(String username, String password){
        product=login.setUserName(username).setPassword(password).clickLoginButton();
        SoftAssert softAssert = new SoftAssert();
        product.addProductToCart("Sauce Labs Backpack");
        product.addProductToCart("Sauce Labs Bike Light");
        softAssert.assertEquals(product.getButtonText("REMOVE","Sauce Labs Backpack"),"REMOVE");
        softAssert.assertEquals(product.getProductPrice("Sauce Labs Backpack"),"29.99","Expected price is $29.99");
        softAssert.assertEquals(product.getProductPrice("Sauce Labs Bike Light"),"9.99","Expected price is $9.99");
        softAssert.assertEquals(product.getCartItemCount(),"2","Expected items count is 2");
        product.addProductToCart("Sauce Labs Fleece Jacket");
        softAssert.assertEquals(product.getCartItemCount(),"3","Expected items count is 3");
        product.removeProduct("Sauce Labs Fleece Jacket");
        softAssert.assertEquals(product.getButtonText("ADD","Sauce Labs Fleece Jacket"),"ADD TO CART");
        softAssert.assertAll();
        inv=product.clickProductIcon("Sauce Labs Onesie");
        Assert.assertEquals(inv.getProductName(),"Sauce Labs Onesie");
        inv.clickAddToCart();
        Assert.assertEquals(inv.getButtonText("REMOVE"),"REMOVE");
        inv.clickRemoveButton();
        Assert.assertEquals(inv.getButtonText("ADD"),"ADD TO CART");
        product=inv.clickBackButton();
        cart=product.clickCartButton();
        Assert.assertEquals(cart.getCartItems(),2,"Expected count in cart to be 2");
        checkout=cart.clickCheckOutButton();
        checkout.setFirstName("Abdallah").clickContinueButton();
        Assert.assertEquals(checkout.getErrorMessage(),"Error: Last Name is required");
        checkout.setLastName("El-Karamany").clickContinueButton();
        Assert.assertEquals(checkout.getErrorMessage(),"Error: Postal Code is required");
        history=checkout.setZipCode("1235").clickContinueButton();
        Assert.assertEquals(history.getItemPrices(),history.getTotalPrice());
        thank=history.clickFinishButton();
        Assert.assertEquals(thank.getThanksMessage(),"THANK YOU FOR YOUR ORDER");
    }
    @Test
    @Parameters({"username", "password"})
    public void lockedOutLogin(String username, String password){


        Assert.assertNotNull(product=login.setUserName(username).setPassword(password).clickLoginButton(),"can not login");
        Assert.assertEquals(product.getButtonText("ADD","Sauce Labs Backpack"),"ADD","user not logged in");
        SoftAssert softAssert = new SoftAssert();
        product.addProductToCart("Sauce Labs Backpack");
        product.addProductToCart("Sauce Labs Bike Light");
        softAssert.assertEquals(product.getButtonText("REMOVE","Sauce Labs Backpack"),"REMOVE");
        softAssert.assertEquals(product.getProductPrice("Sauce Labs Backpack"),"29.99","Expected price is $29.99");
        softAssert.assertEquals(product.getProductPrice("Sauce Labs Bike Light"),"9.99","Expected price is $9.99");
        softAssert.assertEquals(product.getCartItemCount(),"2","Expected items count is 2");
        product.addProductToCart("Sauce Labs Fleece Jacket");
        softAssert.assertEquals(product.getCartItemCount(),"3","Expected items count is 3");
        product.removeProduct("Sauce Labs Fleece Jacket");
        softAssert.assertEquals(product.getButtonText("ADD","Sauce Labs Fleece Jacket"),"ADD TO CART");
        softAssert.assertAll();
        inv=product.clickProductIcon("Sauce Labs Onesie");
        Assert.assertEquals(inv.getProductName(),"Sauce Labs Onesie");
        inv.clickAddToCart();
        Assert.assertEquals(inv.getButtonText("REMOVE"),"REMOVE");
        inv.clickRemoveButton();
        Assert.assertEquals(inv.getButtonText("ADD"),"ADD TO CART");
        product=inv.clickBackButton();
        cart=product.clickCartButton();
        Assert.assertEquals(cart.getCartItems(),2,"Expected count in cart to be 2");
        checkout=cart.clickCheckOutButton();
        checkout.setFirstName("Abdallah").clickContinueButton();
        Assert.assertEquals(checkout.getErrorMessage(),"Error: Last Name is required");
        checkout.setLastName("El-Karamany").clickContinueButton();
        Assert.assertEquals(checkout.getErrorMessage(),"Error: Postal Code is required");
        history=checkout.setZipCode("1235").clickContinueButton();
        Assert.assertEquals(history.getItemPrices(),history.getTotalPrice());
        thank=history.clickFinishButton();
        Assert.assertEquals(thank.getThanksMessage(),"THANK YOU FOR YOUR ORDER");
    }
    @Test
    @Parameters({"username", "password"})
    public void problemUserLogin(String username, String password){
        product=login.setUserName(username).setPassword(password).clickLoginButton();
        SoftAssert softAssert = new SoftAssert();
        product.addProductToCart("Sauce Labs Backpack");
        product.addProductToCart("Sauce Labs Bike Light");
        softAssert.assertEquals(product.getButtonText("REMOVE","Sauce Labs Backpack"),"REMOVE");
        softAssert.assertEquals(product.getProductPrice("Sauce Labs Backpack"),"29.99","Expected price is $29.99");
        softAssert.assertEquals(product.getProductPrice("Sauce Labs Bike Light"),"9.99","Expected price is $9.99");
        softAssert.assertEquals(product.getCartItemCount(),"2","Expected items count is 2");
        product.addProductToCart("Sauce Labs Fleece Jacket");
        softAssert.assertEquals(product.getCartItemCount(),"3","Expected items count is 3");
        product.removeProduct("Sauce Labs Fleece Jacket");
        softAssert.assertEquals(product.getButtonText("ADD","Sauce Labs Fleece Jacket"),"ADD TO CART");
        softAssert.assertAll();
        inv=product.clickProductIcon("Sauce Labs Onesie");
        Assert.assertEquals(inv.getProductName(),"Sauce Labs Onesie");
        inv.clickAddToCart();
        Assert.assertEquals(inv.getButtonText("REMOVE"),"REMOVE");
        inv.clickRemoveButton();
        Assert.assertEquals(inv.getButtonText("ADD"),"ADD TO CART");
        product=inv.clickBackButton();
        cart=product.clickCartButton();
        Assert.assertEquals(cart.getCartItems(),2,"Expected count in cart to be 2");
        checkout=cart.clickCheckOutButton();
        checkout.setFirstName("Abdallah").clickContinueButton();
        Assert.assertEquals(checkout.getErrorMessage(),"Error: Last Name is required");
        checkout.setLastName("El-Karamany").clickContinueButton();
        Assert.assertEquals(checkout.getErrorMessage(),"Error: Postal Code is required");
        history=checkout.setZipCode("1235").clickContinueButton();
        Assert.assertEquals(history.getItemPrices(),history.getTotalPrice());
        thank=history.clickFinishButton();
        Assert.assertEquals(thank.getThanksMessage(),"THANK YOU FOR YOUR ORDER");

    }
    @Test
    @Parameters({"username", "password"})
    public void PerformanceGlitchLogin(String username, String password){
        product=login.setUserName(username).setPassword(password).clickLoginButton();
        SoftAssert softAssert = new SoftAssert();
        product.addProductToCart("Sauce Labs Backpack");
        product.addProductToCart("Sauce Labs Bike Light");
        softAssert.assertEquals(product.getButtonText("REMOVE","Sauce Labs Backpack"),"REMOVE");
        softAssert.assertEquals(product.getProductPrice("Sauce Labs Backpack"),"29.99","Expected price is $29.99");
        softAssert.assertEquals(product.getProductPrice("Sauce Labs Bike Light"),"9.99","Expected price is $9.99");
        softAssert.assertEquals(product.getCartItemCount(),"2","Expected items count is 2");
        product.addProductToCart("Sauce Labs Fleece Jacket");
        softAssert.assertEquals(product.getCartItemCount(),"3","Expected items count is 3");
        product.removeProduct("Sauce Labs Fleece Jacket");
        softAssert.assertEquals(product.getButtonText("ADD","Sauce Labs Fleece Jacket"),"ADD TO CART");
        softAssert.assertAll();
        inv=product.clickProductIcon("Sauce Labs Onesie");
        Assert.assertEquals(inv.getProductName(),"Sauce Labs Onesie");
        inv.clickAddToCart();
        Assert.assertEquals(inv.getButtonText("REMOVE"),"REMOVE");
        inv.clickRemoveButton();
        Assert.assertEquals(inv.getButtonText("ADD"),"ADD TO CART");
        product=inv.clickBackButton();
        cart=product.clickCartButton();
        Assert.assertEquals(cart.getCartItems(),2,"Expected count in cart to be 2");
        checkout=cart.clickCheckOutButton();
        checkout.setFirstName("Abdallah").clickContinueButton();
        Assert.assertEquals(checkout.getErrorMessage(),"Error: Last Name is required");
        checkout.setLastName("El-Karamany").clickContinueButton();
        Assert.assertEquals(checkout.getErrorMessage(),"Error: Postal Code is required");
        history=checkout.setZipCode("1235").clickContinueButton();
        Assert.assertEquals(history.getItemPrices(),history.getTotalPrice());
        thank=history.clickFinishButton();
        Assert.assertEquals(thank.getThanksMessage(),"THANK YOU FOR YOUR ORDER");
    }



}
