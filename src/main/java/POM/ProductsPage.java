package POM;

import Actions.BrowserActions;
import Actions.ElementActions;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ProductsPage {

    String productSelector="//div[@class='inventory_item_label']//div[text()='%s']/ancestor::div[@class='inventory_item']";
    String addToCartButtonSelector=productSelector+"//button[text()='ADD TO CART']";
    String removeFromCartButtonSelector=productSelector+"//button[text()='REMOVE']";
    String priceSelector=productSelector+"//div[@class='inventory_item_price']";
    String cartButtonSelector="a.shopping_cart_link";
    String cartItemCounterSelector="//span[@class='fa-layers-counter shopping_cart_badge']";
    String productIconSelector=productSelector+"//img";
    String productPageLabelSelector="product_label";

    ElementActions act;
    public ProductsPage(){
        act=new ElementActions();
    }
    public ProductsPage addProductToCart(String productName){
        SoftAssert softAssert = new SoftAssert();

            act.clickOnElement(ElementActions.Locator.xPath, String.format(addToCartButtonSelector, productName), ElementActions.Locator.xPath, String.format(removeFromCartButtonSelector, productName), 20);

        return this;
    }
    public ProductsPage removeProduct(String productName) {

        act.clickOnElement(ElementActions.Locator.xPath, String.format(removeFromCartButtonSelector, productName), ElementActions.Locator.xPath, String.format(addToCartButtonSelector, productName), 20);
        return this;
    }
    public String getProductPrice(String productName){

       return act.getElementText(ElementActions.Locator.xPath,String.format(priceSelector,productName),10).replace("$","");
    }
    public String getCartItemCount(){

        return act.getElementText(ElementActions.Locator.xPath,cartItemCounterSelector,20);
    }

    public String getButtonText(String buttonName,String productName){
        String x=null;
        if(buttonName.equals("ADD")){
            x=act.getElementText(ElementActions.Locator.xPath,String.format(addToCartButtonSelector,productName),20);
        }
        else if(buttonName.equals("REMOVE")){
            x=act.getElementText(ElementActions.Locator.xPath,String.format(removeFromCartButtonSelector,productName),20);
        }
        return x;
    }
    public CartPage clickCartButton(){

        act.clickOnElement(ElementActions.Locator.cssSelector,cartButtonSelector,20);
        return new CartPage();
    }
    public InventoryPage clickProductIcon(String productName){
        act.clickOnElement(ElementActions.Locator.xPath,String.format(productIconSelector,productName),5);
        return new InventoryPage();
    }
    public String getPageLabelText(){
        return act.getElementText(ElementActions.Locator.className,productPageLabelSelector,10);
    }



}
