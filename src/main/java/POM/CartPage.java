package POM;

import Actions.ElementActions;

public class CartPage {
    String cartItemsSelector = ".cart_item";
    String removeItemButton = "//div[@class='inventory_item_name' and text()='%s']/ancestor::div[@class='cart_item_label']//button";
    String continueShoppingSelector=".cart_footer .btn_secondary ";
    String checkOutButtonSelector="a.btn_action";
    String CartPageLabelSelector="subheader";
    ElementActions act= null;

    public CartPage() {
        act = new ElementActions();
    }

    public CartPage removeProductFromCart(String productName) {
        act.clickOnElement(ElementActions.Locator.xPath, String.format(removeItemButton, productName), 20);
        return this;
    }
    public int getCartItems(){
        return act.getElements(ElementActions.Locator.cssSelector,cartItemsSelector).size();
    }
    public ProductsPage clickContinueShoppingButton(){
        act.clickOnElement(ElementActions.Locator.cssSelector,continueShoppingSelector,20);
        return new ProductsPage();
    }
    public CheckOutPage clickCheckOutButton(){
        act.clickOnElement(ElementActions.Locator.cssSelector,checkOutButtonSelector,20);
        return new CheckOutPage();
    }
    public String getCartPageTitle(){
        return act.getElementText(ElementActions.Locator.className,CartPageLabelSelector,10);
    }
}
