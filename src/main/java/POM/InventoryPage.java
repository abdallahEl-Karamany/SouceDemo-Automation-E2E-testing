package POM;

import Actions.ElementActions;

public class InventoryPage {
    String productIconNameSelector="inventory_details_name";
    String backButtonSelector="inventory_details_back_button";
    String addToCartButtonSelector="btn_primary";
    String removeButtonSelector="btn_secondary";
    ElementActions act= null;
    public InventoryPage(){
        act=new ElementActions();
    }
    public String getProductName(){
        return act.getElementText(ElementActions.Locator.className,productIconNameSelector,5);
    }
    public ProductsPage clickBackButton(){
        act.clickOnElement(ElementActions.Locator.className,backButtonSelector,5);
        return new ProductsPage();
    }
    public InventoryPage clickAddToCart(){
        act.clickOnElement(ElementActions.Locator.className,addToCartButtonSelector,5);
        return this;
    }
    public InventoryPage clickRemoveButton(){
        act.clickOnElement(ElementActions.Locator.className,removeButtonSelector,5);
        return this;
    }
    public String getButtonText(String buttonName){
        String x=null;
        if(buttonName.equals("ADD")){
            x=act.getElementText(ElementActions.Locator.className,addToCartButtonSelector,5);
        }
        else if(buttonName.equals("REMOVE")){
            x=act.getElementText(ElementActions.Locator.className, removeButtonSelector, 5);
        }
        return x;
    }
}
